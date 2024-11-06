package menu.BasicSettings.EmployeeRegistration.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import menu.BasicSettings.EmployeeRegistration.Dao.busho_setteiDao;
import menu.BasicSettings.EmployeeRegistration.Dao.hatsureiDao;
import menu.BasicSettings.EmployeeRegistration.Dao.heieki_zyouhouDao;
import menu.BasicSettings.EmployeeRegistration.Dao.hoshouninDao;
import menu.BasicSettings.EmployeeRegistration.Dao.huyou_kazokuDao;
import menu.BasicSettings.EmployeeRegistration.Dao.keireki_zyouhouDao;
import menu.BasicSettings.EmployeeRegistration.Dao.kyouiku_kunrenDao;
import menu.BasicSettings.EmployeeRegistration.Dao.kyuuyo_shidai_hokenDao;
import menu.BasicSettings.EmployeeRegistration.Dao.shain_tourokuDao;
import menu.BasicSettings.EmployeeRegistration.Dao.shidai_hoken_zyouhouDao;
import menu.BasicSettings.EmployeeRegistration.Dao.shikaku_menkyouDao;
import menu.BasicSettings.EmployeeRegistration.Dao.shokui_setteiDao;
import menu.BasicSettings.EmployeeRegistration.Dao.shoubatsuDao;
import menu.BasicSettings.EmployeeRegistration.Dao.taishokuDao;
import menu.BasicSettings.EmployeeRegistration.model.busho_settei;
import menu.BasicSettings.EmployeeRegistration.model.hatsurei;
import menu.BasicSettings.EmployeeRegistration.model.heieki_zyouhou;
import menu.BasicSettings.EmployeeRegistration.model.hoshounin;
import menu.BasicSettings.EmployeeRegistration.model.huyou_kazoku;
import menu.BasicSettings.EmployeeRegistration.model.keireki_zyouhou;
import menu.BasicSettings.EmployeeRegistration.model.kyouiku_kunren;
import menu.BasicSettings.EmployeeRegistration.model.kyuuyo_shidai_hoken;
import menu.BasicSettings.EmployeeRegistration.model.shain_touroku;
import menu.BasicSettings.EmployeeRegistration.model.shidai_hoken_zyouhou;
import menu.BasicSettings.EmployeeRegistration.model.shikaku_menkyou;
import menu.BasicSettings.EmployeeRegistration.model.shokui_settei;
import menu.BasicSettings.EmployeeRegistration.model.shoubatsu;
import menu.BasicSettings.EmployeeRegistration.model.taishoku;

public class EmployeeRegistrationService {

    private taishokuDao taishokuDao = new taishokuDao();
    private shoubatsuDao shoubatsuDao = new shoubatsuDao();
    private shokui_setteiDao shokuiSetteiDao = new shokui_setteiDao();
    private shikaku_menkyouDao shikakuMenkyouDao = new shikaku_menkyouDao();
    private shidai_hoken_zyouhouDao shidaiHokenZyouhouDao = new shidai_hoken_zyouhouDao();
    private shain_tourokuDao shainTourokuDao = new shain_tourokuDao();
    private kyuuyo_shidai_hokenDao kyuuyoShidaiHokenDao = new kyuuyo_shidai_hokenDao();
    private kyouiku_kunrenDao kyouikuKunrenDao = new kyouiku_kunrenDao();
    private keireki_zyouhouDao keirekiZyouhouDao = new keireki_zyouhouDao();
    private huyou_kazokuDao huyouKazokuDao = new huyou_kazokuDao();
    private hoshouninDao hoshouninDao = new hoshouninDao();
    private heieki_zyouhouDao heiekiZyouhouDao = new heieki_zyouhouDao();
    private hatsureiDao hatsureiDao = new hatsureiDao();
    private busho_setteiDao bushoSetteiDao = new busho_setteiDao();

    public void saveTaishoku(taishoku taishokuData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            taishokuDao.insert(conn, taishokuData);
            conn.commit();
        }
    }

    public void saveShoubatsu(shoubatsu shoubatsuData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            shoubatsuDao.insert(conn, shoubatsuData);
            conn.commit();
        }
    }

    public void saveShokuiSettei(shokui_settei shokuiSetteiData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            shokuiSetteiDao.insert(conn, shokuiSetteiData);
            conn.commit();
        }
    }

    public void saveShikakuMenkyou(shikaku_menkyou shikakuData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            shikakuMenkyouDao.insert(conn, shikakuData);
            conn.commit();
        }
    }

    public void saveShidaiHoken(shidai_hoken_zyouhou shidaiHokenData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            shidaiHokenZyouhouDao.insert(conn, shidaiHokenData);
            conn.commit();
        }
    }

    public void saveShainTouroku(shain_touroku shainTourokuData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            shainTourokuDao.insert(conn, shainTourokuData);
            conn.commit();
        }
    }

    public void saveKyuuyoShidaiHoken(kyuuyo_shidai_hoken kyuuyoData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            kyuuyoShidaiHokenDao.insertKyuuyoShidaiHoken(conn, kyuuyoData);
            conn.commit();
        }
    }

    public void saveKyouikuKunren(kyouiku_kunren kyouikuData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            kyouikuKunrenDao.insert(conn, kyouikuData);
            conn.commit();
        }
    }

    public void saveKeirekiZyouhou(keireki_zyouhou keirekiData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            keirekiZyouhouDao.insert(conn, keirekiData);
            conn.commit();
        }
    }

    public void saveHuyouKazoku(huyou_kazoku kazokuData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            huyouKazokuDao.insert(conn, kazokuData);
            conn.commit();
        }
    }

    public void saveHoshounin(hoshounin hoshouninData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            hoshouninDao.insert(conn, hoshouninData);
            conn.commit();
        }
    }

    public void saveHeiekiZyouhou(heieki_zyouhou heiekiData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            heiekiZyouhouDao.insert(conn, heiekiData);
            conn.commit();
        }
    }

    public void saveHatsurei(hatsurei hatsureiData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            hatsureiDao.insert(conn, hatsureiData);
            conn.commit();
        }
    }

    public void saveBushoSettei(busho_settei bushoSetteiData) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);
            bushoSetteiDao.insert(conn, bushoSetteiData);
            conn.commit();
        }
    }
}
