package com.yq.blueray.security.dao;


import com.yq.blueray.security.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

	List<User> getByMap(Map<String, Object> map);
	List<User> getByRoleId(Map<String, Object> map);
	User getById(Integer id);
	Integer create(User user);
	int update(User user);
	User getByUserName(String userName);
}