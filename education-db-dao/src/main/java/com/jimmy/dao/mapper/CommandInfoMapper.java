package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CommandInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommandInfoMapper {

    int insert(CommandInfo record);


    List<CommandInfo> list(@Param("courseId") Long courseId,@Param("typeList") List<Integer> typeList,@Param("siteIdList")List<Long> siteIdList);


}