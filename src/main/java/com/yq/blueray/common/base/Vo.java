package com.yq.blueray.common.base;

public interface Vo<T> {
	T getInstance();
	
	void setInstance(T t);
}
