package com.model.dao;

import com.core.DB;
import com.model.dto.MemberBean;
import java.sql.*;
import org.mindrot.jbcrypt.*;
import java.util.ArrayList;

/**
 * 회원 추가, 삭제, 조회, 로그인
 *
 */
public class Member {
	/**
	 * 회원 추가
	 * 
	 * @param member
	 * @return Boolean true - 추가 성공
	 */
	public boolean insertMember(MemberBean member) {
		if (member == null) 
			return false;
		
		String memPw = BCrypt.hashpw(member.getMemPw(), BCrypt.gensalt(10));
		
		String sql = "CALL InsertMember(?, ?, ?)";
		try (Connection conn = DB.getConnection();
			 CallableStatement cstmt = conn.prepareCall(sql)) {
			cstmt.setString(1, member.getMemId());
			cstmt.setString(2, memPw);
			cstmt.setString(3, member.getMemNm());
			int rs = cstmt.executeUpdate(); // 반영된 투플의 갯수 
			if (rs > 0) 
				return true;
			
		} catch (SQLException | ClassNotFoundException e) {
			// 로그 기록 ... 
			return false;
		}
		
		return false;
	}
	
	/**
	 * 회원 목록 
	 * 
	 * @return ArrayList 
	 */
	public ArrayList<MemberBean> getMembers() {
		ArrayList<MemberBean> list = new ArrayList<>();
		
		String sql = "SELECT * FROM member2";
		try(Connection conn = DB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			// .next() -> 다음 투플이 있는 체크 true -> 다음 투플로 이동 
			while(rs.next()) {
				list.add(new MemberBean(rs));
			}
			
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			// 로그 기록 
		}
		
		
		return list;
	}
	
	/**
	 * 회원 삭제 
	 * 
	 * @param memId 회원 아이디 
	 * @return 삭제 성공 true
	 */
	public boolean deleteMember(String memId) {
		
		String sql = "CALL DeleteMember(?)";
		try(Connection conn = DB.getConnection();
			CallableStatement cstmt = conn.prepareCall(sql)) {
			cstmt.setString(1, memId);
			int rs = cstmt.executeUpdate();  // 반영된 투플의 갯수 
			if (rs > 0) 
				return true;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// 로그 기록
			return false;
		}
		
		return false;
	}
	
	/**
	 * 로그인 처리 
	 * 
	 * @param memId 아이디 
	 * @param memPw 비밀번호 
	 * @return 로그인 성공 true
	 */
	public boolean login(String memId, String memPw) {
		
		String sql = "SELECT * FROM member2 WHERE memId = ?";
		try(Connection conn = DB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, memId);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { 
				String hash = rs.getString("memPw");
				return BCrypt.checkpw(memPw, hash);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// 로그 기록 ....
			
			return false;
		}
		
		return false;
	}
}