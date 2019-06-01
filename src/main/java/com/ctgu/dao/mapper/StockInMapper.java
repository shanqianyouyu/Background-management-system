package com.ctgu.dao.mapper;

import com.ctgu.pojo.StockIn;
import com.ctgu.pojo.StockInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockInMapper {
    int countByExample(StockInExample example);

    int deleteByExample(StockInExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockIn record);

    int insertSelective(StockIn record);

    List<StockIn> selectByExample(StockInExample example);

    StockIn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockIn record, @Param("example") StockInExample example);

    int updateByExample(@Param("record") StockIn record, @Param("example") StockInExample example);

    int updateByPrimaryKeySelective(StockIn record);

    int updateByPrimaryKey(StockIn record);
}