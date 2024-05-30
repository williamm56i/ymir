package com.williamm56i.ymir.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.williamm56i.ymir.controller.dto.SysUserDto;
import com.williamm56i.ymir.persistence.dao.SysUserDao;
import com.williamm56i.ymir.persistence.vo.SysUser;
import com.williamm56i.ymir.security.YmirUserDetailsService;
import com.williamm56i.ymir.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    YmirUserDetailsService userDetailsService;

    @Override
    public SysUser getSysUser(String account) {
        return sysUserDao.selectByPrimaryKey(account);
    }

    @Override
    public PageInfo<SysUser> paginateSysUser(SysUserDto dto) {
        return PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrderString())
                .doSelectPageInfo(() -> sysUserDao.selectByConditions(dto.getAccount(), dto.getUserName(), dto.getEmail()));
    }

    @Override
    public void createSysUser(SysUserDto dto) {
        SysUser sysUser = new SysUser();
        sysUser.setAccount(dto.getAccount());
        sysUser.setUserName(dto.getUserName());
        sysUser.setEmail(dto.getEmail());
        sysUser.setCreateId(userDetailsService.getUsername());
        sysUser.setCreateDate(new Date());
        sysUserDao.insertSelective(sysUser);
    }

    @Override
    public void removeSysUser(String account) {
        sysUserDao.deleteByPrimaryKey(account);
    }

    @Override
    public void modifySysUser(SysUserDto dto) {
        SysUser sysUser = new SysUser();
        sysUser.setAccount(dto.getAccount());
        sysUser.setUserName(dto.getUserName());
        sysUser.setEmail(dto.getEmail());
        sysUser.setUpdateId(userDetailsService.getUsername());
        sysUser.setUpdateDate(new Date());
        sysUserDao.updateByPrimaryKeySelective(sysUser);
    }
}
