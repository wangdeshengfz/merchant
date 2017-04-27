package com.bosssoft.itfinance.epay.v2.merchant.common.mybatis.page.dialect;



public class MySql5Dialect extends Dialect{
	
	protected static final String SQL_END_DELIMITER = ";";
	
	public String getLimitString(String sql, boolean hasOffset) {
		return MySql5PageHepler.getLimitString(sql,-1,-1);
	}

	public String getLimitString(String sql, int offset, int limit) {
		return MySql5PageHepler.getLimitString(sql, offset, limit);
	}

	public boolean supportsLimit() {
		return true;
	}

	
	public String getCountSql(String sql) {
		return MySql5PageHepler.getCountString(sql);
	}

	
	public String getLimitSql(String sql, int offset, int limit) {
		return  sql+" limit "+ offset +" ,"+ limit;
	}
}
