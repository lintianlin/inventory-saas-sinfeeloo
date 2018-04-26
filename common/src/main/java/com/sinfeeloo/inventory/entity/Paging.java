package com.sinfeeloo.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Paging
 * @Author: mhj
 * @Desc:  分页方法
 * @Date: 2018/4/26 9:11
 */
public class Paging<T> implements Serializable {

	private static final long serialVersionUID = 755183539178076901L;

	private static Integer defaultSize = 20;

	private long total;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<T> list;

	@JsonIgnore
	private Map<String, Object> searchMap;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object search;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer pageNo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer size;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T totalColum;

	private Paging() {
	}

	private void init() {
		total = 0L;
		list = new ArrayList<T>();
		searchMap = new HashMap<String, Object>();
	}

	public Paging(Integer pageNo) {
		init();
		setPageNo(pageNo);
		setSize(defaultSize);
	}

	public Paging(Integer pageNo, Integer size) {
		init();
		setPageNo(pageNo);
		if (size == null) {
			setSize(defaultSize);
		} else {
			this.setSize(size);
		}
	}

	public Paging(long total, List<T> rows) {
		this.total = total;
		this.list = rows;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotal() {
		return total;
	}

	public void setList(List<T> data) {
		this.list = data;
	}

	public List<T> getList() {
		return list;
	}

	public Map<String, Object> getSearchMap() {
		return searchMap;
	}

	public Paging<T> putSearch(String key, Object val) {
		searchMap.put(key, val);
		return this;
	}

	public Object getSearch() {
		return search;
	}

	public void setSearch(Object search) {
		if (search == null) {
			return;
		}
		Field[] fields = search.getClass().getDeclaredFields();

		for (Field field : fields) {
			try {
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), search.getClass());
				Object value = propertyDescriptor.getReadMethod().invoke(search);
				if (value != null) {
					searchMap.put(field.getName(), propertyDescriptor.getReadMethod().invoke(search));
				}
			} catch (Exception e) {
				e.fillInStackTrace();
			}
		}
		this.search = search;
	}

	public void setSize(Integer size) {
		this.size = size;
		searchMap.put("offset", (this.pageNo - 1) * size);
		searchMap.put("limit", size);
		searchMap.put("end", this.pageNo * size);
	}

	public Integer getSize() {
		return this.size;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo == null ? 1 : pageNo;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public static <T> Paging<T> empty(Class<T> clazz) {
		List emptyList = Collections.emptyList();
		return new Paging(Long.valueOf(0L), emptyList);
	}

	public T getTotalColum() {
		return totalColum; // add by zhaomeinan
	}

	public void setTotalColum(T totalColum) {
		this.totalColum = totalColum; // add by zhaomeinan
	}

}
