package model.mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class MemDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean insert(MemVO vo) {
		conn = JNDI.connect();
		String sql = "insert into mem values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMpw());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean login(MemVO vo) {
		conn = JNDI.connect();
		String sql = "select mid,mpw from mem where mid = ?";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getString("mpw").equals(vo.getMpw()))
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return result;
	}
	
	public boolean newMem(MemVO vo) {
		conn = JNDI.connect();
		String sql = "INSERT INTO MEM VALUES (?,?,?)";
		boolean res = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMpw());
			pstmt.executeUpdate();
				res=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public ArrayList<MemVO> selectAll() {
		ArrayList<MemVO> datas = new ArrayList<MemVO>();
		conn = JNDI.connect();
		String sql = "select * from mem";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemVO data=new MemVO();
				data.setName(rs.getString("name"));
				data.setMpw(rs.getString("mpw"));
				data.setMid(rs.getString("mid"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;
	}
	
}
