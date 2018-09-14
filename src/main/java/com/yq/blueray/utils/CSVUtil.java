package com.yq.blueray.utils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.yq.blueray.common.base.Generator;
import com.yq.blueray.common.base.impl.generator.BasicGenerator;
import org.apache.commons.beanutils.BeanUtils;


import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 把csv文件转换成list集合
 *
 * @author yq
 *
 * @param <T>
 */
public class CSVUtil<T> {

	private static Logger log = LoggerFactory.getLogger(CSVUtil.class);

	private static CSVReader csvReader;

	private static Reader reader;

	private static ICSVParser parser;

	private static Set<Integer> inculdeColumns;


	CSVUtil(){}

	/**
	 * 读取
	 *
	 * @param c class类型
	 * @param is	需要读取的文件
	 * @return 返回集合
	 */
	public static <T> List<T> csvToList(Class<T> c,InputStream is){
		Properties pro = new Properties();
		return read(c,is,pro);
	}

	/**
	 * 读取重载
	 *
	 * @param c
	 * @param is
	 * @param pro 自己设置好的配置文件pro
	 *
	 * @return
	 */
	public static <T> List<T> csvToList(Class<T> c, InputStream is, Properties pro){
		return read(c,is,pro);
	}

	/**
	 *
	 * 文件读取到对象中
	 *
	 * @param c 类型
	 *
	 * @param is 流
	 *
	 * @return
	 */
	private static <T>  List<T> read(Class<T> c,InputStream is,Properties pro){

		getReader(is);

		List<T> result = writeToObj(c,pro);

		closeReader();

		return result;

	}

	/**
	 * 关闭
	 */
	private static void closeReader() {
		try {
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 写入对象
	 *
	 * @param c
	 * @return
	 */
	private static <T> List<T> writeToObj(Class<T> c,Properties pro){

		//获取原始的list
		List<String[]> list = readToList();

		//把list封装成对象
		return stringArrayListToObjectList(list,c,pro);

	}

	/**
	 *
	 * 把string数组转换成object集合
	 *
	 * @param list
	 * @param c
	 * @return
	 */
	private static <T> List<T> stringArrayListToObjectList(List<String[]> list,Class<T> c,Properties pro) {
		Properties properties = createProperties(list,pro);
		Generator<T> generator = getGenerator(c);
		List<T> result = new LinkedList<T>();
		int size = list.size();

		for(int i = 0 ; i < size;i++){
			T t = generator.next();
			for (Integer j : inculdeColumns) {
				stringArrayToObject(t,properties.get(j.toString()).toString(),list.get(i)[j]);
			}
			result.add(t);
		}
		return result;
	}


	/**
	 * 把相对应的内容写入对象中
	 *
	 * @param t
	 * @param name
	 * @param value
	 */
	private static <T> void stringArrayToObject(T t,String name,String value){
		try {
			BeanUtils.setProperty(t, name, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 创建一个properties
	 *
	 *
	 * @param list
	 * @param pro
	 */
	private static Properties createProperties(List<String[]> list, Properties pro) {
		String[] header = list.remove(0);
		//如果为空，就创建一个
		if(pro == null)
			pro =  new Properties();

		//如果pro没有值,设置第一行
		if(pro.isEmpty())
			setDefaultHeader(Arrays.asList(header),pro);
		//对比header获取有效列数
		getEffectiveColumn(header,pro);
		return pro;
	}

	/**
	 * 获取有效的列数
	 *
	 * @param headers
	 * @param pro
	 */
	private static void getEffectiveColumn(String[] headers, Properties pro) {
		inculdeColumns = new HashSet<>();
		for (int i = 0;i< headers.length;i++) {

			if(pro.get(headers[i]) != null){
				log.debug("包含的列为:第" + i + "列" + ",字段名为:"+headers[i]+",属性名为:" + pro.get(headers[i]));
				pro.setProperty(String.valueOf(i), pro.get(headers[i]).toString());
				inculdeColumns.add(i);
			}

		}
	}

	/**
	 * 设置默认值
	 *
	 * @param asList
	 * @param pro
	 */
	private static void setDefaultHeader(List<String> asList, Properties pro) {
		asList.forEach(s->pro.setProperty(s, s));
	}

	/**
	 * 读取成list<String[]> 集合
	 *
	 * @return
	 */
	private static List<String[]> readToList() {
		try {
			return csvReader.readAll();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取生成器,可以扩展
	 *
	 * @param c
	 * @return
	 */
	private static <T>  Generator<T> getGenerator(Class<T> c) {
		return BasicGenerator.create(c);
	}

	/**
	 *
	 * 获取csvreader
	 *
	 * @param is
	 */
	private static void getReader(InputStream is) {
		try {
			reader = new InputStreamReader(is,"GBK");
		} catch (Exception e) {
			try {
				reader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		createReader(new CSVReaderBuilder(reader));
	}

	/**
	 * 可扩展性
	 *
	 * @param csvReaderBuilder
	 */
	private static void createReader(CSVReaderBuilder csvReaderBuilder) {
		//可以设置参数,如果设计类，可以继承扩展

		createParser(new CSVParserBuilder());
		csvReaderBuilder.withCSVParser(parser);
		csvReader = csvReaderBuilder.build();
	}

	/**
	 * 可扩展性
	 *
	 * @param csvParserBuilder
	 */
	private static void createParser(CSVParserBuilder csvParserBuilder) {
		//可以设置参数,如果设计类，可以继承扩展

		parser = csvParserBuilder.build();
	}


}
