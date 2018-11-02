package com.yq.common.base.impl.vo;



import com.yq.common.base.Vo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractVo<T> implements Vo<T> {

	private T instance;
	
	private Integer page;
	
	private Integer limit;

	@Override
	public T getInstance() {
		
		return instance;
	}

	@Override
	public void setInstance(T instance) {
		this.instance = instance;
	}

}
