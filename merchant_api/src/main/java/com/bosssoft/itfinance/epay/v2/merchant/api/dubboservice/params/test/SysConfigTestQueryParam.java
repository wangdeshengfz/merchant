package com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.params.test;

import java.io.Serializable;

public class SysConfigTestQueryParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	/** 配置代码 */
	private String code;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
