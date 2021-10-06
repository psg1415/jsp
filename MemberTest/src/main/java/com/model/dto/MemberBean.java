package com.model.dto;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberBean {
	private int memNo;
	private String memId;
	private String memPw;
	private String memNm;
	
	public MemberBean() {}
	
	public MemberBean(HttpServletRequest request) {
		this.memId = request.getParameter("memId");
		this.memNm = request.getParameter("memNm");
		this.memPw = request.getParameter("memPw");
	}
	
	public MemberBean(ResultSet rs) throws SQLException {
		this.memNo = rs.getInt("memNo");
		this.memId = rs.getString("memId");
		this.memNm = rs.getString("memNm");
	}
	
	public MemberBean(int memNo, String memId, String memNm) {
		this.memNo = memNo;
		this.memId = memId;
		this.memNm = memNm;
	}
	
	public int getMemNo() {
		return memNo;
	}
	
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	
	public String getMemId() {
		return memId;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getMemNm() {
		return memNm;
	}
	
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	
	public String getMemPw() {
		return memPw;
	}
	
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
}