package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {

	private MemberDao memberDao = new MemberDao();

	public void join(JoinRequest joinReq) {
	    Connection conn = null;
	    try {
	        conn = ConnectionProvider.getConnection();
	        conn.setAutoCommit(false);

	        // 아이디 중복 확인
	        Member member = memberDao.selectById(conn, joinReq.getId());
	        if (member != null) {
	            JdbcUtil.rollback(conn); // 트랜잭션 롤백
	            throw new DuplicateIdException(); // 중복된 아이디 예외 발생
	        }

	        // 회원 정보 삽입
	        memberDao.insert(conn, 
	        		new Member(
	            joinReq.getId(),
	            joinReq.getName(),
	            joinReq.getPassword(),
	            new Date()) // 현재 날짜/시간
	        );

	        conn.commit(); // 트랜잭션 커밋
	    } catch(SQLException e) {
	    	JdbcUtil.rollback(conn);
	    	throw new RuntimeException(e);
	    }
	    // 예외 처리 및 자원 반환
	    finally {
	        JdbcUtil.close(conn);
	    }
	}

}
