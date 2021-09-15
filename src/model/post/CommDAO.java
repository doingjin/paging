package model.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class CommDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean newComm(CommVO vo) {
		boolean res=false;
		conn=JNDI.connect();
		String SQL="INSERT INTO COMM VALUES((SELECT NVL(MAX(CNUM),0)+1 FROM COMM),?,?,SYSDATE,?)";
		// CNUM PNUM MID CDATE COMM
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getPnum());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getComm());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("newComm()에서 출력");
			e.printStackTrace();
			return false;
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public boolean delComm(CommVO vo) {
		boolean res=false;
		conn=JNDI.connect();
		String SQL="DELETE FROM COMM WHERE CNUM=?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getCnum());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("delComm()에서 출력");
			e.printStackTrace();
			return false;
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return res;
	}
	
	
}
