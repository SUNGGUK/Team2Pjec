package menu.retirement.RetirementPaySlip.Controller;
import java.sql.Date;

public class RetirementPaySlipTest {

    public static void main(String[] args) {
        // 테스트할 날짜 문자열 (예: "2023-01-01" 형식)
        String startDateStr = "2023-01-01";
        String endDateStr = "2023-12-31";
        
        // null 여부 확인을 위한 메서드 호출
        checkDateRange(startDateStr, endDateStr);

        // null 값을 테스트하기 위해 추가 테스트
        checkDateRange(null, endDateStr);
        checkDateRange(startDateStr, null);
        checkDateRange(null, null);
    }

    // 날짜 범위를 확인하고 null 여부를 출력하는 메서드
    public static void checkDateRange(String startDateParam, String endDateParam) {
        try {
            // startDateParam과 endDateParam을 Date로 변환
            Date startDate = startDateParam != null ? Date.valueOf(startDateParam) : null;
            Date endDate = endDateParam != null ? Date.valueOf(endDateParam) : null;

            // 변환된 값 확인 및 null 여부 출력
            if (startDate != null && endDate != null) {
                System.out.println("startDate: " + startDate);
                System.out.println("endDate: " + endDate);
                System.out.println("두 날짜 모두 null이 아닙니다.");
            } else {
                if (startDate == null) {
                    System.out.println("startDate가 null입니다.");
                }
                if (endDate == null) {
                    System.out.println("endDate가 null입니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 날짜 형식입니다. 날짜는 'YYYY-MM-DD' 형식이어야 합니다.");
            e.printStackTrace();
        }
    }
}
