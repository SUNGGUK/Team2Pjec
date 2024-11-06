package menu.BasicSettings.UserInfo.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import menu.BasicSettings.UserInfo.Dao.Tantousha_ZyouhouDao;
import menu.BasicSettings.UserInfo.Model.Tantousha_Zyouhou;

// 담당자 정보 서비스 클래스
// 担当者情報サービスクラス
public class TantoushaZyouhouService {

    private final Tantousha_ZyouhouDao tantoushaDao;

    public TantoushaZyouhouService() {
        this.tantoushaDao = new Tantousha_ZyouhouDao();
    }

    // 담당자 정보 조회
    // 担当者情報を取得
    public Tantousha_Zyouhou getTantoushaInfo(Connection conn, String namae) throws SQLException {
        return tantoushaDao.selectTantoushaInfo(conn, namae);
    }

    // 담당자 정보 저장 및 업데이트
    // 担当者情報を保存および更新
    public void saveOrUpdateTantoushaInfo(Connection conn, Tantousha_Zyouhou tantousha) throws SQLException {
        // DB에 담당자 정보가 있는지 확인 후, 존재하면 업데이트, 아니면 삽입
        // DBに担当者情報があるか確認し、存在すれば更新、なければ挿入
        Tantousha_Zyouhou existingTantousha = tantoushaDao.selectTantoushaInfo(conn, tantousha.getNamae());
        if (existingTantousha == null) {
            tantoushaDao.insert(conn, tantousha);
        } else {
            tantoushaDao.update(conn, tantousha);
        }
    }

    // 부서 목록 조회
    // 部署リストを取得
    public List<String> getDepartments(Connection conn) throws SQLException {
        return tantoushaDao.selectAllDepartments(conn);
    }

    // 직위 목록 조회
    // 職位リストを取得
    public List<String> getPositions(Connection conn) throws SQLException {
        return tantoushaDao.selectAllPositions(conn);
    }
}
