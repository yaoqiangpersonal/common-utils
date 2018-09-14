package com.yq.blueray.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.yq.blueray.common.base.impl.predicate.BeanPredicateExtend;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.EqualPredicate;


public class CollectionUtil {

	private static Predicate<?> predicate;

	private static <T,E> Collection<T> filter(Collection<? extends T> collection,
			String field, E param) {
		predicate = new EqualPredicate<E>(param);
		Predicate<T> bp = createPredicate(field,predicate);
		return CollectionUtils.select(collection, bp);
	}
	
	/**
	 * @param list
	 * @param field
	 * @param param
	 * @return
	 */
	public static <T,E> List<T> checkList(List<T> list,String field, E param){
		return new ArrayList<T>(filter(list,field,param));
	}
	
	private static <T,E> Predicate<T> createPredicate(String field,Predicate<E> predicate2) {
		return  new BeanPredicateExtend<>(field, predicate);
	}

}
