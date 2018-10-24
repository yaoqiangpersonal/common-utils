package com.yq.blueray.common.utils;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 * 
 * @author lfy
 * 
 */

public enum Msg {
	SUCCESS(200,"处理成功！"),

	NOT_FOUND(404,"资源找不到！"),

	PASSWORD_ERROR(4011,"密码错误！"),

	USERNAME_ERROR(4010,"用户名错误！"),

	CHECKCODE_ERROR(4012,"验证码错误！"),

	FORBIDDEN(403,"没有权限，被禁止！"),

	FAIL(500,"处理失败！");


	//状态码   200-成功    404-失败
	private final int code;
	//提示信息
	private final String msg;

	//用户要返回给浏览器的数据
	private final Map<String, Object> extend = new HashMap<String, Object>();

	Msg(final int code,final String msg){
		this.code = code;
		this.msg = msg;
	};

	public Msg add(final String key,final Object value){
		extend.put(key, value);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Map<String, Object> getExtend() {
		return Collections.unmodifiableMap(extend);
	}

}
