package com.models.goods;

import java.util.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import static com.core.DB.setBinding;

import org.mindrot.jbcrypt.*;
import com.core.*;
import com.core.Req;
import com.models.*;



public class GoodsDao {
	
	private static GoodsDao instance = new GoodsDao();
	private static HttpServletRequest request;
		
	private GoodsDao() {};  // 기본 생성자 private -> 외부 생성 X, 내부에서만 생성 O
	
	public static GoodsDao getInstance() {
		if (instance == null) {
			instance = new GoodsDao();
		}
		
		if (request == null) {
			request = Req.get();
		}
			
		return instance;
	}
	
	/**
	 * 상품 등록 /goods/add
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public boolean addGoods(HttpServletRequest request) throws Exception {
		HashMap<String, String> params = FileUpload.getInstance().upload(request).get();
		
		/** 유효성 검사 */
		checkGoodsData(params);
		
		ArrayList<DBField> bindings = new ArrayList<>();
		String sql = "INSERT INTO goods (goodsImage, goodsNm, goodsPrice, goodsCategory, goodsExplain) VALUES (?,?,?,?,?)";
		String goodsImage = "";
		String goodsNm = "";
		String goodsPrice = "";
		String goodsCategory = "";
		String goodsExplain = "";
		
		bindings.add(DB.setBinding("Blob", params.get("goodsImage")));
		bindings.add(DB.setBinding("String", params.get("goodsNm")));
		bindings.add(DB.setBinding("Integer", params.get("goodsPrice")));
		bindings.add(DB.setBinding("String", params.get("goodsCategory")));
		bindings.add(DB.setBinding("String", params.get("goodsExplain")));
		
		
		int rs = DB.executeUpdate(sql, bindings);
		
		return (rs > 0)?true:false;
		}
		
	/**
	 * 상품 수정
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public boolean editGoods(HttpServletRequest request) throws Exception {
		HashMap<String, String> params = FileUpload.getInstance().upload(request).get();
		
		/** 유효성 검사 */
		checkGoodsData(params);
		
		String sql = "UPDATE goods SET goodsImage =?, goodsNm = ?, goodsPrice = ?, goodsCategory = ?, goodsExplain = ?, modDt = NOW() WHERE goodsNo = ?";
		ArrayList<DBField> bindings = new ArrayList<>();
		bindings.add(DB.setBinding("Blob", params.get("goodsImage")));
		bindings.add(DB.setBinding("String", params.get("goodsNm")));
		bindings.add(DB.setBinding("Integer", params.get("goodsPrice")));
		bindings.add(DB.setBinding("String", params.get("goodsCategory")));
		bindings.add(DB.setBinding("String", params.get("goodsExplain")));
		bindings.add(DB.setBinding("Integer", params.get("goodsNo")));
		
		int rs = DB.executeUpdate(sql, bindings);
		
		return (rs > 0)?true:false;
	}
	
	/**
	 * 상품 추가, 수정시 데이터 검증 
	 * 
	 * @param params
	 * @throws Exception
	 */
	public void checkGoodsData(HashMap<String, String> params) throws Exception {
		String[] required = {
				"goodsImage//상품이미지를 입력하세요",
				"goodsNm//상품명을 입력하세요.",
				"goodsPrice//상품가격을 입력하세요",
				"goodsCategory//상품카테고리를 입력하세요",
				"goodsExplain//상품 상세설명을 입력하세요",
		};
		for (String s : required) {
			String[] param = s.split("//");
			String value = params.get(param[0]);
			if (value == null || value.trim().equals("")) {
				throw new Exception(param[1]);
			}
		}
	}
	
	/**
	 * 카테고리별 조회 /category/"categoryname"
	 * 
	 * @param goodsCategory
	 * @return
	 */
	public ArrayList<Goods> getList(Object object) {
		HashMap<String, String> params = FileUpload.getInstance().upload(request).get();
		
		ArrayList<DBField> bindings = new ArrayList<>();
		String sql = "SELECT * FROM goods WHERE goodsCategory = ?";
		bindings.add(DB.setBinding("String", params.get("goodsCategory")));

		sql += " ORDER BY goodsNm DESC";
		
		ArrayList<Goods> list = DB.executeQuery(sql,  bindings, new Goods());
		
		return list;
	}
	
	public boolean deleteGoods(int goodsNo) {
		ArrayList<DBField> bindings = new ArrayList<>();
		String sql = "DELETE FROM goods WHERE goodsNo = ?";
		bindings.add(DB.setBinding("Integer", String.valueOf(goodsNo)));
		int rs = DB.executeUpdate(sql, bindings);
		
		return (rs > 0)?true:false;
	}
}