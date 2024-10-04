package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import article.model.Article;

public class DeleteArticleService {

    private ArticleDao articleDao = new ArticleDao();
    private ArticleContentDao contentDao = new ArticleContentDao();

    public void delete(DeleteRequest delReq) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false);

            // 게시글이 존재하는지 확인
            Article article = articleDao.selectById(conn, delReq.getArticleNumber());
            if (article == null) {
                throw new ArticleNotFoundException();
            }

            // 삭제 권한이 있는지 확인
            if (!canDelete(delReq.getUserId(), article)) {
                throw new PermissionDeniedException();
            }

            // article_content와 article 테이블에서 모두 삭제
            contentDao.delete(conn, delReq.getArticleNumber());
            articleDao.delete(conn, delReq.getArticleNumber());

            conn.commit();
        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            throw new RuntimeException(e);
        } catch (PermissionDeniedException e) {
            JdbcUtil.rollback(conn);
            throw e;
        } finally {
            JdbcUtil.close(conn);
        }
    }

    private boolean canDelete(String deletingUserId, Article article) {
        return article.getWriter().getId().equals(deletingUserId);
    }
}
