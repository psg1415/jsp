package com.models;

import java.sql.*;

public abstract class Dto<T> {
	/** 
	 * ResultSetÀ¸·Î °ª ÁöÁ¤
	 * @param rs
	 */
	public abstract T setResultSet(ResultSet rs) throws SQLException;
}