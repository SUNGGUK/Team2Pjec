package menu.BasicSettings.UserInfo.Service;

import java.sql.Connection;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Dao.KaishaZyouhouDao;
import menu.BasicSettings.UserInfo.Model.KaishaZyouhou;

// 회사 정보 서비스
// 会社情報サービス
public class KaishaZyouhouService {

    private final KaishaZyouhouDao kaishaZyouhouDao;

    public KaishaZyouhouService() {
        this.kaishaZyouhouDao = new KaishaZyouhouDao();
    }

    // 회사 정보 조회 메서드 (최근에 저장된 정보)
    // 会社情報を取得するメソッド (最新の保存情報)
    public KaishaZyouhou getCompanyInfo(Connection conn) throws SQLException {
        return kaishaZyouhouDao.getLatestCompanyInfo(conn);
    }

    // 회사 정보 저장 또는 업데이트 메서드
    // 会社情報を保存または更新するメソッド
    public int saveOrUpdateCompanyInfo(Connection conn, KaishaZyouhou kaishaZyouhou) throws SQLException {
        return kaishaZyouhouDao.saveOrUpdateCompanyInfo(conn, kaishaZyouhou);
    }
}
