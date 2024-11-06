package menu.retirement.EmployeeRetirementProcessing.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import jdbc.connection.ConnectionProvider;
import menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;

public class RetirementProcessingDAOTest {

    public static void main(String[] args) {
        RetirementProcessingDAO dao = RetirementProcessingDAO.getInstance();

        // selectAll 메서드를 사용하여 데이터 조회
        try (Connection conn = ConnectionProvider.getConnection()) {
            List<RetirementProcessing> list = dao.selectAll(conn);

            // 가져온 데이터 출력
            if (list != null && !list.isEmpty()) {
                System.out.println("main 메서드에서 가져온 데이터:");
                
                for (RetirementProcessing rp : list) {
                    System.out.println(rp.toString());
                }

                // 첫 번째 데이터를 업데이트할 객체로 선택
                RetirementProcessing rpToUpdate = list.get(0);
                rpToUpdate.setZyoutai("아아아아");
                rpToUpdate.setTaishoku_bi(new Date(System.currentTimeMillis())); // 현재 날짜로 설정
                rpToUpdate.setTaishoku_kubun("오오오");
                rpToUpdate.setChuukan_seisan_umu(true);
                rpToUpdate.setTaishoku_seisan_umu(true);

                // update 메서드를 별도의 연결에서 호출하여 업데이트 실행
                try (Connection updateConn = ConnectionProvider.getConnection()) {
                    updateConn.setAutoCommit(false); // 트랜잭션 수동 관리
                    dao.update(updateConn, rpToUpdate);
                    updateConn.commit(); // 커밋
                    System.out.println("업데이트 성공: " + rpToUpdate.toString());
                } catch (SQLException e) {
                    System.out.println("업데이트 중 오류 발생: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("main 메서드에서 데이터를 가져오지 못했습니다.");
            }
        } catch (SQLException e) {
            System.out.println("데이터 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
