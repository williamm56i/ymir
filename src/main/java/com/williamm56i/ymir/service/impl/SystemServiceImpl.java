package com.williamm56i.ymir.service.impl;

import com.williamm56i.ymir.persistence.dao.SysCodeDao;
import com.williamm56i.ymir.persistence.dao.SysUserDao;
import com.williamm56i.ymir.persistence.vo.SysCode;
import com.williamm56i.ymir.service.SystemService;
import com.williamm56i.ymir.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {

    @Autowired
    SysCodeDao sysCodeDao;
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public String getTest(String name) {
        return "hello world! " + name;
    }

    @Override
    public String generateToken(String account) {
        if (sysUserDao.selectByPrimaryKey(account) != null) {
            return JwtUtils.generate(account);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public String refreshToken(String jwt) {
        return JwtUtils.refresh(jwt);
    }

    @Override
    public List<SysCode> getSysCodeAll() {
        return sysCodeDao.selectAll();
    }
}
