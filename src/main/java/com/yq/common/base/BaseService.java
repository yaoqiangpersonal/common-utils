package com.yq.common.base;

import com.yq.common.base.impl.vo.AbstractVo;

import java.io.Serializable;
import java.util.List;




/**
 * 
 * BaseService
 * 
 * @author yq
 *
 * @param <T> 
 */
public interface BaseService<T> {
	
	/**
	 * 增加
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int add(T t) throws Exception;


	/**
	 * 批量添加
	 *
	 * @param list
	 * @return
	 * @throws Exception
	 */
	int addBatch(List<T> list) throws Exception;
	
	/**
	 * 
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteById(Serializable id) throws Exception;
	
	/**
	 * 修改
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int update(T t) throws Exception;
	
	/**
	 * 选择性修改
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int updateSelective(T t) throws Exception;
	
	
	
	T findById(int id) throws Exception;
	
	/**
	 * 
	 * 通过视图来进行查询
	 * 
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<T> findByVo(AbstractVo<? extends T> vo) throws Exception;

}
