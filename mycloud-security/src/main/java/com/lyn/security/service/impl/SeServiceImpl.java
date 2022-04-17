package com.lyn.security.service.impl;

import com.lyn.security.service.SeService;
import org.springframework.stereotype.Service;

@Service
public class SeServiceImpl implements SeService {

    @Override
    public String getName(String id) {
        return "test";
    }

    @Override
    public String getEmail(String name) {
        return "18823888@qq.com";
    }
}
