package com.app.service.impl;

import com.app.entity.Nhom;
import com.app.repo.NhomRepo;
import com.app.service.NhomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhomServiceImpl implements NhomService {

    @Autowired
    NhomRepo nhomRepo;

    @Override
    public List<Nhom> findAll() {
        return nhomRepo.findAll();
    }
}
