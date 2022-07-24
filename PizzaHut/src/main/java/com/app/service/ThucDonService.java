package com.app.service;

import com.app.dao.response.ThucDonResponse;
import com.app.entity.ThucDon;

import java.util.List;

public interface ThucDonService {

    List<ThucDon> findAll();

    List<ThucDonResponse> responseFindAll();

}
