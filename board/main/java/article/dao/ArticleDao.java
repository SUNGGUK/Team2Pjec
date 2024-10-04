package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import article.model.Writer;
import jdbc.JdbcUtil;

public class ArticleDao {

    public Article insert(Connection conn, Article article)
        throws SQLException {
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("insert into article "
                + "(article_no, writer_id, writer_name, title, regdate, moddate, read_cnt) "
                + "values (art_seq.nextval,?,?,?,?,?,0)");
            pstmt.setString(1, article.getWriter().getId());
            pstmt.setString(2, article.getWriter().getName());
            pstmt.setString(3, article.getTitle());
            pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
            pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select art_seq.currval from dual");
                if (rs.next()) {
                    Integer newNum = rs.getInt(1);
                    return new Article(newNum,
                        article.getWriter(),
                        article.getTitle(),
                        article.getRegDate(),
                        article.getModifiedDate(),
                        0);
                }
            }
            return null;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
            JdbcUtil.close(pstmt);
        }
    }

    private Timestamp toTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }
    
    public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            // Oracle에서는 LIMIT 대신 ROW_NUMBER()를 사용하여 페이징 처리
            String sql = "SELECT * FROM ( " +
                         "  SELECT a.*, ROW_NUMBER() OVER (ORDER BY article_no DESC) as rnum " +
                         "  FROM article a " +
                         ") WHERE rnum BETWEEN ? AND ?";
            psmt = conn.prepareStatement(sql);

            // startRow와 size 값을 사용하여 페이징 처리
            psmt.setInt(1, startRow);
            psmt.setInt(2, startRow + size - 1);

            rs = psmt.executeQuery();
            List<Article> result = new ArrayList<>();
            while (rs.next()) {
                result.add(convertArticle(rs));
            }
            return result;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(psmt);
        }
    }

    private Article convertArticle(ResultSet rs) throws SQLException {
        return new Article(rs.getInt("article_no"),
                           new Writer(
                               rs.getString("writer_id"),
                               rs.getString("writer_name")),
                           rs.getString("title"),
                           toDate(rs.getTimestamp("regdate")),
                           toDate(rs.getTimestamp("moddate")),
                           rs.getInt("read_cnt"));
    }
    
    private Date toDate(Timestamp timestamp) {
        return new Date(timestamp.getTime());
    }

    
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select count(*) from article");
            if(rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }
    
    public Article selectById(Connection conn, int no) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(
                "select * from article where article_no = ?");
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            Article article = null;
            if (rs.next()) {
                article = convertArticle(rs);
            }
            return article;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    public void increaseReadCount(Connection conn, int no) throws SQLException {
        try (PreparedStatement pstmt =
            conn.prepareStatement(
                "update article set read_cnt = read_cnt + 1 " +
                "where article_no = ?")) {
            pstmt.setInt(1, no);
            pstmt.executeUpdate();
        }
    }

    public int update(Connection conn, int no, String title) throws SQLException {
        try (PreparedStatement pstmt = 
            		conn.prepareStatement(
            			    "update article set title = ?, moddate = SYSDATE " +
            			    "where article_no = ?")
            		) {
            pstmt.setString(1, title);
            pstmt.setInt(2, no);
            return pstmt.executeUpdate();
        }
    }
    public void delete(Connection conn, int articleNumber) throws SQLException {
        // 먼저 article_content 테이블에서 게시글 내용을 삭제
        String sqlContent = "DELETE FROM article_content WHERE article_no = ?";
        try (PreparedStatement pstmtContent = conn.prepareStatement(sqlContent)) {
            pstmtContent.setInt(1, articleNumber);
            pstmtContent.executeUpdate();
        }

        // article 테이블에서 게시글 메타데이터 삭제
        String sqlArticle = "DELETE FROM article WHERE article_no = ?";
        try (PreparedStatement pstmtArticle = conn.prepareStatement(sqlArticle)) {
            pstmtArticle.setInt(1, articleNumber);
            pstmtArticle.executeUpdate();
        }
    }

    
}
