package menu.BasicSettings.UserInfo.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Model.KaishaZyouhou;
import menu.BasicSettings.UserInfo.Model.KyuuyoShikyuuZyouhou;
import menu.BasicSettings.UserInfo.Model.Tantousha_Zyouhou;

// 사용자 정보 저장 서비스 클래스
// ユーザー情報保存サービスクラス
public class UserInfoSaveService {

    private final KaishaZyouhouService kaishaZyouhouService;
    private final KyuuyoShikyuuZyouhouService kyuuyoShikyuuZyouhouService;
    private final StanpuService stanpuService;
    private final TantoushaZyouhouService tantoushaZyouhouService;

    public UserInfoSaveService() {
        this.kaishaZyouhouService = new KaishaZyouhouService();
        this.kyuuyoShikyuuZyouhouService = new KyuuyoShikyuuZyouhouService();
        this.stanpuService = new StanpuService();
        this.tantoushaZyouhouService = new TantoushaZyouhouService();
    }

    // 전체 정보 저장
    // 全体情報を保存する
    public void saveAllInfo(Connection conn, KaishaZyouhou companyInfo, KyuuyoShikyuuZyouhou salaryInfo, 
                            Tantousha_Zyouhou tantoushaInfo, File logoImage, File sealImage) throws SQLException, IOException {
        try {
            conn.setAutoCommit(false); // 트랜잭션 시작
            // トランザクションを開始

            // 회사 정보 저장
            // 会社情報を保存
            kaishaZyouhouService.saveOrUpdateCompanyInfo(conn, companyInfo);

            // 급여 정보 저장
            // 給与情報を保存
            kyuuyoShikyuuZyouhouService.saveKyuuyoShikyuuInfo(conn, salaryInfo);

            // 담당자 정보 저장
            // 担当者情報を保存
            tantoushaZyouhouService.saveOrUpdateTantoushaInfo(conn, tantoushaInfo);

            // 로고 및 도장 이미지 저장
            // ロゴと印鑑イメージを保存
            if (logoImage != null) {
                stanpuService.registerLogo(conn, logoImage);
            }
            if (sealImage != null) {
                stanpuService.registerSeal(conn, sealImage);
            }

            conn.commit(); // 트랜잭션 커밋
            // トランザクションをコミット
        } catch (SQLException | IOException e) {
            conn.rollback(); // 에러 발생 시 롤백
            // エラー発生時にロールバック
            throw e;
        } finally {
            conn.setAutoCommit(true); // 자동 커밋 모드 복원
            // 自動コミットモードを復元
        }
    }
}
