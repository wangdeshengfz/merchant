package com.bosssoft.itfinance.epay.v2.merchant.common.page;

import java.util.List;

/**
 * 列表分页。包含list属性
 * @author Poppy Kwoks
 * @dateTime Apr 20, 2014  10:59:51 AM
 */
public class Pagination extends SimplePage {

	public Pagination() {
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 */
	public Pagination(int pageNo, int pageSize) {
		super(pageNo, pageSize);
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param list
	 *            分页内容
	 */

	public Pagination(int pageNo, int pageSize, List<?> list) {
		super(pageNo, pageSize);
		this.list = list;
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	/**
	 * 第一条数据位置
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (pageNo - 1) * spageSize;
	}

	/**
	 * 当前页的数据
	 */
	private List<?> list;

	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * 
	 * @param list
	 */
	public List<?> setList(List<?> list) {
		return this.list = list;
	}

	public Pagination isGetTotalCount(boolean getTotalCount) {
		this.getTotalCount = getTotalCount;
		return this;
	}

	
	
}
