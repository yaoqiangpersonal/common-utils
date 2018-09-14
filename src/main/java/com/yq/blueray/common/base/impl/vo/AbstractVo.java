package com.yq.blueray.common.base.impl.vo;


import com.yq.blueray.common.base.Vo;

public abstract class AbstractVo<T> implements Vo<T> {

	private T instance;
	
	private Integer page;
	
	private Integer limit;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public T getInstance() {
		
		return instance;
	}

	@Override
	public void setInstance(T instance) {
		this.instance = instance;
	}

}
