package com.yq.blueray.crawler.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.blueray.crawler.po.Bluray;
import org.apache.ibatis.annotations.Mapper;


import java.io.PrintStream;

/**
 * @Auther: yq
 * @Date: 2018-09-21 12:03
 * @Description:
 */
@Mapper
public interface CamelMapper extends BaseMapper<Bluray> {

}
