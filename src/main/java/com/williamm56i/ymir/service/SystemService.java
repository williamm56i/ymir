package com.williamm56i.ymir.service;

import com.williamm56i.ymir.persistence.vo.SysCode;

import java.util.List;

public interface SystemService {

    String getTest(String name);

    List<SysCode> getSysCodeAll();
}
