package model.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class PostDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<PostSet> selectAll(String mid, int cnt){
		ArrayList<PostSet> plist=new ArrayList<PostSet>();
		conn=JNDI.connect();
		String SQL;
		try {
			// 전체
			if((mid == null) || (mid.equals(""))) {
				SQL = "SELECT * FROM (SELECT * FROM POST ORDER BY PDATE DESC) WHERE ROWNUM <=?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, cnt);
				//System.out.println("if맞음?");
			}
			
			// 특정 회원
			else{
				SQL = "SELECT * FROM (SELECT * FROM POST ORDER BY PDATE DESC) WHERE MID=? AND ROWNUM <=?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1,mid);
				pstmt.setInt(2,cnt);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostSet ps=new PostSet();
				PostVO p=new PostVO();
				ArrayList<CommVO> clist=new ArrayList<CommVO>();
				
				p.setPnum(rs.getInt("pnum"));
				p.setMid(rs.getString("mid"));
				p.setContent(rs.getString("content"));
				p.setFavcnt(rs.getInt("favcnt"));
				p.setPdate(rs.getDate("pdate"));
				
				String CSQL="SELECT * FROM COMM WHERE PNUM=? ORDER BY CDATE ASC";
				pstmt=conn.prepareStatement(CSQL);
				pstmt.setInt(1, rs.getInt("pnum"));
				ResultSet crs=pstmt.executeQuery();
				int comcnt=0;
				while(crs.next()) {
					CommVO c=new CommVO();
					c.setCnum(crs.getInt("cnum"));
					c.setPnum(crs.getInt("pnum"));
					c.setMid(crs.getString("mid"));
					c.setComm(crs.getString("comm"));
					c.setCdate(crs.getDate("cdate"));
					clist.add(c);
					comcnt++;
				}
				p.setComcnt(comcnt);
				
				ps.setP(p);
				ps.setClist(clist);
				plist.add(ps);
				crs.close();
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("PostDAO - selectALL 에서 출력");
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		
		return plist;
	}
	
	public int getPostnum(String mid) {
		int cnt=0;
		conn=JNDI.connect();
		String SQL;
		try {
			if(mid==""||mid==null) {
				SQL="SELECT * FROM POST";
				pstmt=conn.prepareStatement(SQL);
				
			} else {
				SQL="SELECT * FROM POST WHERE MID=?";
				pstmt=conn.prepareStatement(SQL);
				pstmt.setString(1, mid);
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				cnt++;
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println("getPostnum에서 출력");
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return cnt;
	}
	
	public boolean newPost(PostVO vo) {
		boolean res=false;
		conn=JNDI.connect();
		String sql="INSERT INTO POST VALUES((SELECT NVL(MAX(PNUM),0)+1 FROM POST),?,?,0,SYSDATE)";
		// PNUM MID CONTENT FAVCNT PDATE
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("newPost()에서 출력");
			e.printStackTrace();
			return false;
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public boolean delPost(PostVO vo) {
		boolean res=false;
		conn=JNDI.connect();
		String SQL="DELETE FROM POST WHERE PNUM=?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("delPost()에서 출력");
			e.printStackTrace();
			return false;
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public boolean addFav(PostVO vo) {
		boolean res=false;
		conn=JNDI.connect();
		String SQL="UPDATE POST SET FAVCNT=FAVCNT+1 WHERE PNUM=?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("addFav()에서 출력");
			e.printStackTrace();
			return false;
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return res;
	}
	
	
}
