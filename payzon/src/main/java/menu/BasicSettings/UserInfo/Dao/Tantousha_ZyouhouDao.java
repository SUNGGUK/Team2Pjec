package menu.BasicSettings.UserInfo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import menu.BasicSettings.UserInfo.Model.Tantousha_Zyouhou;

// 담당자 정보 DAO 클래스
// 担当者情報DAOクラス
public class Tantousha_ZyouhouDao {

    // 담당자 정보 삽입 메서드
    // 担当者情報を挿入するメソッド
    public int insert(Connection conn, Tantousha_Zyouhou tantousha) throws SQLException {
        String insertQuery = "INSERT INTO tantousha_zyouhou (namae, bu, yakushoku, denwa_bangou, keitai_bangou, meiru_adoresu) "
                           + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, tantousha.getNamae());
            pstmt.setString(2, tantousha.getBu());
            pstmt.setString(3, tantousha.getYakushoku());
            pstmt.setString(4, tantousha.getDenwa_bangou());
            pstmt.setString(5, tantousha.getKeitai_bangou());
            pstmt.setString(6, tantousha.getMeiru_adoresu());

            return pstmt.executeUpdate();
        }
    }

    // 이름을 기반으로 담당자 정보 조회 메서드
    // 名前を基に担当者情報を取得するメソッド
    public Tantousha_Zyouhou selectTantoushaInfo(Connection conn, String namae) throws SQLException {
        String selectQuery = "SELECT * FROM tantousha_zyouhou WHERE namae = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
            pstmt.setString(1, namae);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Tantousha_Zyouhou(
                        rs.getString("namae"),
                        rs.getString("bu"),
                        rs.getString("yakushoku"),
                        rs.getString("denwa_bangou"),
                        rs.getString("keitai_bangou"),
                        rs.getString("meiru_adoresu")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    // 담당자 정보 업데이트 메서드
    // 担当者情報を更新するメソッド
    public int update(Connection conn, Tantousha_Zyouhou tantousha) throws SQLException {
        String updateQuery = "UPDATE tantousha_zyouhou SET bu = ?, yakushoku = ?, denwa_bangou = ?, " +
                             "keitai_bangou = ?, meiru_adoresu = ? WHERE namae = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, tantousha.getBu());
            pstmt.setString(2, tantousha.getYakushoku());
            pstmt.setString(3, tantousha.getDenwa_bangou());
            pstmt.setString(4, tantousha.getKeitai_bangou());
            pstmt.setString(5, tantousha.getMeiru_adoresu());
            pstmt.setString(6, tantousha.getNamae());

            return pstmt.executeUpdate();
        }
    }

    // 모든 부서 목록 조회 메서드
    // 全ての部署のリストを取得するメソッド
    public List<String> selectAllDepartments(Connection conn) throws SQLException {
        String selectQuery = "SELECT busho_mei FROM busho_settei";
        List<String> departments = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(selectQuery);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                departments.add(rs.getString("busho_mei"));
            }
        }
        return departments;
    }

    // 모든 직위 목록 조회 메서드
    // 全ての職位のリストを取得するメソッド
    public List<String> selectAllPositions(Connection conn) throws SQLException {
        String selectQuery = "SELECT shokui_mei FROM shokui_settei";
        List<String> positions = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(selectQuery);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                positions.add(rs.getString("shokui_mei"));
            }
        }
        return positions;
    }
}
