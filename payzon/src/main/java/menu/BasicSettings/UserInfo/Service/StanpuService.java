package menu.BasicSettings.UserInfo.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import menu.BasicSettings.UserInfo.Dao.StanpuHenkouRirekiDao;
import menu.BasicSettings.UserInfo.Model.StanpuHenkouRireki;

// 스탬프 서비스 클래스 (로고 및 도장 관리)
// スタンプサービスクラス (ロゴと印鑑の管理)
public class StanpuService {

    private final StanpuHenkouRirekiDao rirekiDao;
    private final String logoDirectory = "C:\\path\\to\\upload\\directory\\logo";
    private final String sealDirectory = "C:\\path\\to\\upload\\directory\\seal";

    public StanpuService() {
        this.rirekiDao = new StanpuHenkouRirekiDao();
    }

    // 로고 등록 메서드
    // ロゴ登録メソッド
    public void registerLogo(Connection conn, File imageFile) throws SQLException, IOException {
        registerStanpu(conn, "로고", imageFile, logoDirectory);
    }

    // 도장 등록 메서드
    // 印鑑登録メソッド
    public void registerSeal(Connection conn, File imageFile) throws SQLException, IOException {
        registerStanpu(conn, "도장", imageFile, sealDirectory);
    }

    // 공통 등록 메서드 (로고 또는 도장)
    // 共通登録メソッド (ロゴまたは印鑑)
    private void registerStanpu(Connection conn, String stanpuType, File imageFile, String directoryPath) throws SQLException, IOException {
        String fileName = stanpuType + ".jpg";  // 항상 동일한 파일명으로 저장하여 최신 파일 유지
        // 常に同じファイル名で保存し、最新のファイルを維持
        Path destination = Paths.get(directoryPath, fileName);

        // 이미지 파일을 해당 경로에 저장 (기존 파일 덮어쓰기)
        // 画像ファイルを指定のパスに保存 (既存ファイルを上書き)
        Files.copy(imageFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

        // 변경 이력 기록
        // 変更履歴を記録
        StanpuHenkouRireki rireki = new StanpuHenkouRireki(
            0,  // 자동 증가할 기본 키
            // 自動増加する主キー
            stanpuType,
            new java.sql.Date(new Date().getTime()),  // 신청일
            // 申請日
            "등록",
            "이미지 등록됨",
            destination.toString()  // 파일 경로
            // ファイルパス
        );
        rirekiDao.insertStanpuHenkouRireki(conn, rireki);
    }

    // 로고 삭제 메서드
    // ロゴ削除メソッド
    public boolean deleteLogo(Connection conn) throws SQLException, IOException {
        return deleteStanpu(conn, "로고", logoDirectory);
    }

    // 도장 삭제 메서드
    // 印鑑削除メソッド
    public boolean deleteSeal(Connection conn) throws SQLException, IOException {
        return deleteStanpu(conn, "도장", sealDirectory);
    }

    // 공통 삭제 메서드 (로고 또는 도장)
    // 共通削除メソッド (ロゴまたは印鑑)
    private boolean deleteStanpu(Connection conn, String stanpuType, String directoryPath) throws SQLException, IOException {
        Path filePath = Paths.get(directoryPath, stanpuType + ".jpg");

        // 파일이 존재할 경우 삭제
        // ファイルが存在する場合削除
        if (Files.exists(filePath)) {
            Files.delete(filePath);

            // 변경 이력 기록
            // 変更履歴を記録
            StanpuHenkouRireki rireki = new StanpuHenkouRireki(
                0,
                stanpuType,
                new java.sql.Date(new Date().getTime()),
                "삭제",
                "이미지 삭제됨",
                null
            );
            rirekiDao.insertStanpuHenkouRireki(conn, rireki);

            return true;
        } else {
            System.out.println(stanpuType + " 파일이 존재하지 않습니다.");
            return false;
        }
    }

    // 로고 수정 요청 메서드
    // ロゴ修正リクエストメソッド
    public void requestLogoModification(Connection conn, File newImageFile) throws SQLException, IOException {
        requestStanpuModification(conn, "로고", newImageFile, logoDirectory);
    }

    // 도장 수정 요청 메서드
    // 印鑑修正リクエストメソッド
    public void requestSealModification(Connection conn, File newImageFile) throws SQLException, IOException {
        requestStanpuModification(conn, "도장", newImageFile, sealDirectory);
    }

    // 공통 수정 요청 메서드 (로고 또는 도장)
    // 共通修正リクエストメソッド (ロゴまたは印鑑)
    private void requestStanpuModification(Connection conn, String stanpuType, File newImageFile, String directoryPath) throws SQLException, IOException {
        registerStanpu(conn, stanpuType, newImageFile, directoryPath);

        // 수정 요청 이력 기록
        // 修正リクエスト履歴を記録
        StanpuHenkouRireki rireki = new StanpuHenkouRireki(
            0,
            stanpuType,
            new java.sql.Date(new Date().getTime()),
            "수정 요청",
            "이미지 수정 요청됨",
            null
        );
        rirekiDao.insertStanpuHenkouRireki(conn, rireki);
    }
}
