package menu.retirement.EmployeeRetirementProcessing.Controller;

import java.util.Scanner;
import menu.retirement.EmployeeRetirementProcessing.Model.Taisha_shanotorikeshi;
import menu.retirement.EmployeeRetirementProcessing.Service.TaishaShanotorikeshiService;

public class TaishaShanotorikeshiControllerTest {

	public static void main(String[] args) {
        // 서비스 객체 생성
        TaishaShanotorikeshiService taishaService = new TaishaShanotorikeshiService();

        // 콘솔에서 사원 ID를 입력받기 위해 Scanner 사용
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 사원 ID를 입력하세요: ");
        
        // 사원 ID 입력
        int shainId;
        try {
            shainId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 숫자 형식입니다. 프로그램을 종료합니다.");
            scanner.close();
            return;
        }
        
        scanner.close(); // Scanner 자원 해제

        try {
            // getTaishaShanotorikeshi 메서드로 데이터 조회
            Taisha_shanotorikeshi taisha = taishaService.getTaishaShanotorikeshi(shainId);

            // 조회 결과 확인
            if (taisha != null) {
                System.out.println("=== 사원 정보 ===");
                System.out.println("사원 ID: " + taisha.getShain_ID());
                System.out.println("퇴직 구분: " + taisha.getTaishoku_kubun());
                System.out.println("퇴직 일자: " + taisha.getTaishoku_bi());
                System.out.println("퇴직 사유: " + taisha.getTaishoku_ziyuu());
                System.out.println("퇴직 후 연락처: " + taisha.getTaishoku_go_renrakusaki());
            } else {
                System.out.println("해당 사원의 정보를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("데이터 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}