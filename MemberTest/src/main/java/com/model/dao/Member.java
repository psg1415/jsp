package com.model.dao;

import com.core.DB;
import com.model.dto.MemberBean;
import java.sql.*;
import org.mindrot.jbcrypt.*;
import java.util.ArrayList;

/**
 * ȸ�� �߰�, ����, ��ȸ, �α���
 *
 */
public class Member {
	/**
	 * ȸ�� �߰�
	 * 
	 * @param member
	 * @return Boolean true - �߰� ����
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
			int rs = cstmt.executeUpdate(); // �ݿ��� ������ ���� 
			if (rs > 0) 
				return true;
			
		} catch (SQLException | ClassNotFoundException e) {
			// �α� ��� ... 
			return false;
		}
		
		return false;
	}
	
	/**
	 * ȸ�� ��� 
	 * 
	 * @return ArrayList 
	 */
	public ArrayList<MemberBean> getMembers() {
		ArrayList<MemberBean> list = new ArrayList<>();
		
		String sql = "SELECT * FROM member2";
		try(Connection conn = DB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			// .next() -> ���� ������ �ִ� üũ true -> ���� ���÷� �̵� 
			while(rs.next()) {
				list.add(new MemberBean(rs));
			}
			
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			// �α� ��� 
		}
		
		
		return list;
	}
	
	/**
	 * ȸ�� ���� 
	 * 
	 * @param memId ȸ�� ���̵� 
	 * @return ���� ���� true
	 */
	public boolean deleteMember(String memId) {
		
		String sql = "CALL DeleteMember(?)";
		try(Connection conn = DB.getConnection();
			CallableStatement cstmt = conn.prepareCall(sql)) {
			cstmt.setString(1, memId);
			int rs = cstmt.executeUpdate();  // �ݿ��� ������ ���� 
			if (rs > 0) 
				return true;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// �α� ���
			return false;
		}
		
		return false;
	}
	
	/**
	 * �α��� ó�� 
	 * 
	 * @param memId ���̵� 
	 * @param memPw ��й�ȣ 
	 * @return �α��� ���� true
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
			// �α� ��� ....
			
			return false;
		}
		
		return false;
	}
}