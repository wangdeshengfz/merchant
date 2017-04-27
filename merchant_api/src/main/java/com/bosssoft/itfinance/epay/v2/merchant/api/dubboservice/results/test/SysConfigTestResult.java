package com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.results.test;

import java.io.Serializable;

public class SysConfigTestResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	/** 配置代码 */
	private String code;

	/** 配置值 */
	private String value;

	/** 备注 */
	private String note;

	/** 创建时间 */
	private String createtime;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
