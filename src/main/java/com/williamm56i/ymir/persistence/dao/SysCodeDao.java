package com.williamm56i.ymir.persistence.dao;

import com.williamm56i.ymir.persistence.vo.SysCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysCodeDao {

    List<SysCode> selectAll();

    List<SysCode> selectByGroup(@Param("sysGroup") String group);
}
