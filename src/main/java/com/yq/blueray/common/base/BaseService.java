package com.yq.blueray.common.base;

import java.util.List;

import com.yq.blueray.common.base.impl.vo.AbstractVo;


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
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int delete(T t) throws Exception;
	
	/**
	 * 修改
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int update(T t) throws Exception;
	
	/**
	 * 选择性添加
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int addSelective(T t) throws Exception;
	
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
