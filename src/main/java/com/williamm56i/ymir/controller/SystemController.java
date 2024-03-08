package com.williamm56i.ymir.controller;

import com.williamm56i.ymir.persistence.vo.SysCode;
import com.williamm56i.ymir.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    @Autowired
    SystemService systemService;

    @GetMapping("/test")
    public ResponseEntity<String> getTest(@RequestParam("name") String name) {
        return ResponseEntity.ok(systemService.getTest(name));
    }

    @GetMapping("/getSysCodeAll")
    public ResponseEntity<List<SysCode>> getSysCodeAll() {
        return ResponseEntity.ok(systemService.getSysCodeAll());
    }
}
