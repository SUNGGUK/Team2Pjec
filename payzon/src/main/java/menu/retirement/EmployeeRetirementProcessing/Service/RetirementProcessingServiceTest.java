package menu.retirement.EmployeeRetirementProcessing.Service;

import java.sql.SQLException;
import java.util.List;

import menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;

public class RetirementProcessingServiceTest {

    public static void main(String[] args) {
        RetirementProcessingService service = new RetirementProcessingService();

        try {
            // 모든 퇴직 처리 데이터를 가져오기
            List<RetirementProcessing> list = service.getAllRetirementProcessing();

            // 결과 확인 및 콘솔 출력
            if (list != null && !list.isEmpty()) {
                System.out.println("Service Test: 데이터가 존재합니다. 총 항목 수 = " + list.size());
                for (RetirementProcessing rp : list) {
                    System.out.println(rp.toString()); // 각 객체의 정보를 출력, toString 메서드 필요
                }
            } else {
                System.out.println("Service Test: 데이터가 비어 있습니다.");
            }

            // 총 항목 수 확인
            int totalCount = service.getTotalRetirementCount();
            System.out.println("총 퇴직 처리 항목 수: " + totalCount);

        } catch (SQLException e) {
            System.out.println("테스트 중 데이터베이스 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
