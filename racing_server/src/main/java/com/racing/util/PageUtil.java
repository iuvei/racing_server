package com.racing.util;

public class PageUtil {

	private Integer pageIndex;
	
	private Integer pageSize;

	private PageUtil(Integer pageIndex, Integer pageSize){
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	
	/**
	 * 
	 * @param pageIndex 当前页数从1开始
	 * @param pageSize 每页数据条数
	 * @return
	 */
	public static PageUtil createPage(Integer pageIndex, Integer pageSize){
		return new PageUtil(pageIndex, pageSize);
	}
	
	/**
	 * 生成默认pageSize（10）的分页
	 * @param pageIndex 当前页数从1开始
	 * @return
	 */
	public static PageUtil createDefaultPage(Integer pageIndex){
		return new PageUtil(pageIndex, 10);
	}
	
	/**
	 * 获取只获取一个数据的limit条件
	 * @return
	 */
	public static String getOneLimit(){
		return " limit 0,1";
	}
	
	
	/**
	 * 获取分页查询时的limit 语句，用于setOrderByClause方法的参数，注意要有排序，同时放到最后边
	 * 如：example.setOrderByClause(" id ASC " + page.getLimit());
	 * @return
	 */
	public String getLimit(){
		if(pageIndex == null){
			throw new RuntimeException("Page's pageIndex can not null");
		}
		if(pageSize == null){
			throw new RuntimeException("Page's pageSize can not null");
		}
		int start = (pageIndex-1)*pageSize;
		
		return " limit " + start + "," + pageSize;
		
	}

	public Integer getStart(){
		if(pageIndex == null){
			throw new RuntimeException("Page's pageIndex can not null");
		}
		if(pageSize == null){
			throw new RuntimeException("Page's pageSize can not null");
		}
		
		int start = (pageIndex-1)*pageSize;
		return start;
	}
	
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
