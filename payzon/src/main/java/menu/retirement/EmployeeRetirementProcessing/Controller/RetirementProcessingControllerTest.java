package menu.retirement.EmployeeRetirementProcessing.Controller;

import java.sql.SQLException;
import java.util.List;

import menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;
import menu.retirement.EmployeeRetirementProcessing.Service.RetirementProcessingService;

public class RetirementProcessingControllerTest {

    public static void main(String[] args) {
        // RetirementProcessingService를 이용해 데이터 확인 테스트
        RetirementProcessingService retirementProcessingService = new RetirementProcessingService();

        try {
            // 전체 데이터 수 조회 및 페이지 계산
            int itemsPerPage = 10;
            int totalItems = retirementProcessingService.getTotalRetirementCount();
            int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

            // 모든 퇴직 처리 데이터를 가져오기
            List<RetirementProcessing> list = retirementProcessingService.getAllRetirementProcessing();
            
            // 결과 확인 및 콘솔 출력
            if (list != null && !list.isEmpty()) {
                System.out.println("Controller Test: 데이터가 존재합니다. 총 항목 수 = " + list.size());
                for (RetirementProcessing rp : list) {
                    System.out.println(rp.toString()); // toString 메서드 구현 필요
                }
            } else {
                System.out.println("Controller Test: 데이터가 비어 있습니다.");
            }

            System.out.println("총 페이지 수: " + totalPages);
            System.out.println("현재 페이지: 1"); // 기본값으로 설정된 값

        } catch (SQLException e) {
            System.out.println("테스트 중 데이터베이스 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
