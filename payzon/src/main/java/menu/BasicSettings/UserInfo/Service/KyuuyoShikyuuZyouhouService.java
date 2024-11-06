package menu.BasicSettings.UserInfo.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import menu.BasicSettings.UserInfo.Dao.KyuuyoShikyuuZyouhouDao;
import menu.BasicSettings.UserInfo.Model.KyuuyoShikyuuZyouhou;

// 급여 지급 정보 서비스
// 給与支給情報サービス
public class KyuuyoShikyuuZyouhouService {

    private final KyuuyoShikyuuZyouhouDao kyuuyoShikyuuZyouhouDao;

    public KyuuyoShikyuuZyouhouService() {
        this.kyuuyoShikyuuZyouhouDao = new KyuuyoShikyuuZyouhouDao();
    }

    // 급여 지급 정보 저장
    // 給与支給情報の保存
    public int saveKyuuyoShikyuuInfo(Connection conn, KyuuyoShikyuuZyouhou kyuuyoInfo) throws SQLException {
        return kyuuyoShikyuuZyouhouDao.insertKyuuyoShikyuuInfo(conn, kyuuyoInfo);
    }

    // 사원의 계좌 번호 조회
    // 社員の口座番号を取得
    public Optional<String> getKouzaBangou(Connection conn, int shainID) throws SQLException {
        String kouzaBangou = kyuuyoShikyuuZyouhouDao.getKouzaBangou(conn, shainID);
        return Optional.ofNullable(kouzaBangou);
    }

    // 사원의 급여 지급 정보 조회
    // 社員の給与支給情報を取得
    public KyuuyoShikyuuZyouhou getKyuuyoShikyuuZyouhouByShainID(Connection conn, int shainID) throws SQLException {
        return kyuuyoShikyuuZyouhouDao.getKyuuyoShikyuuZyouhouByShainID(conn, shainID);
    }
}
