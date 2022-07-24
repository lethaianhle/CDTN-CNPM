package com.app.service.impl;

import com.app.dao.response.ComboResponse;
import com.app.entity.Combo;
import com.app.entity.ThucDon;
import com.app.repo.ComboRepo;
import com.app.repo.ComboThucDonRepo;
import com.app.repo.ThucDonRepo;
import com.app.service.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComboServiceImpl implements ComboService {

    @Autowired
    ComboRepo comboRepo;

    @Autowired
    ComboThucDonRepo comboThucDonRepo;

    @Autowired
    ThucDonRepo thucDonRepo;

    @Override
    public List<Combo> findAll() {
        return comboRepo.findAll();
    }

    @Override
    public List<ComboResponse> responseFindAll() {
        List<Combo> comboList = comboRepo.findAll();
        List<ComboResponse> comboResponses = new ArrayList<>();

        for (int i = 0; i < comboList.size(); i++) {
            List<ThucDon> listThucDonByComboId =
                    comboThucDonRepo.findAllThucDonByComboId(comboList.get(i).getId());

            List<String> listNameThucDonByComboId =
                    comboThucDonRepo.findAllNameThucDonByComboId(comboList.get(i).getId());

            ComboResponse comboResponse = ComboResponse.builder()
                    .description(comboList.get(i).getDescription())
                    .discountPercent(comboList.get(i).getDiscountPercent())
                    .image(comboList.get(i).getImage())
                    .totalPrice(comboList.get(i).getTotalPrice())
                    .priceAfterDiscount(comboList.get(i).getPriceAfterDiscount())
                    .name(comboList.get(i).getName())
                    .id(comboList.get(i).getId())
                    .listThucDon(listThucDonByComboId)
                    .listNameThucDon(listNameThucDonByComboId)
                    .build();

            comboResponses.add(comboResponse);
        }

        return comboResponses.size() > 0 ? comboResponses : null;
    }

}
