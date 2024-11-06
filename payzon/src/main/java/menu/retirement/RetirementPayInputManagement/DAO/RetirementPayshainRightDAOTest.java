package menu.retirement.RetirementPayInputManagement.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import menu.retirement.RetirementPayInputManagement.Model.RetirementPayshain;

public class RetirementPayshainRightDAOTest {

    public static void main(String[] args) {
        RetirementPayshainRightDAO dao = RetirementPayshainRightDAO.getInstance();

        // 테스트할 파라미터 설정
        String department = "Sales"; // 테스트할 부서 이름
        int currentPage = 1; // 테스트할 페이지 번호
        int recordsPerPage = 10; // 페이지당 레코드 수

        try (Connection conn = ConnectionProvider.getConnection()) {
            // selectByDepartment 메서드 호출하여 데이터 가져오기
            List<RetirementPayshain> list = dao.selectByDepartment(conn, department, currentPage, recordsPerPage);

            // 결과 확인 및 콘솔 출력
            if (list != null && !list.isEmpty()) {
                System.out.println("DAO Test: 데이터가 존재합니다. 총 항목 수 = " + list.size());
                for (RetirementPayshain rp : list) {
                    System.out.println(rp.toString()); // 각 객체의 정보를 출력, toString 메서드 필요
                }
            } else {
                System.out.println("DAO Test: 데이터가 비어 있습니다.");
            }

        } catch (SQLException e) {
            System.out.println("테스트 중 데이터베이스 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

