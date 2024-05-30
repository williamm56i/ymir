package com.williamm56i.ymir.persistence.dao;

import com.williamm56i.ymir.persistence.vo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDao {

    List<SysUser> selectAll();

    SysUser selectByPrimaryKey(@Param("account") String account);
}
