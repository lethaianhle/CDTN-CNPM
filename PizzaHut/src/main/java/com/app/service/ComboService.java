package com.app.service;

import com.app.dao.response.ComboResponse;
import com.app.entity.Combo;

import java.util.List;

public interface ComboService {

    List<Combo> findAll();

    List<ComboResponse> responseFindAll();

}
