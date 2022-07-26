package com.app.service.impl;

import com.app.dao.response.ThucDonResponse;
import com.app.entity.Nhom;
import com.app.entity.ThucDon;
import com.app.exception.NhomNotFoundException;
import com.app.exception.ThucDonNotFoundException;
import com.app.repo.NhomRepo;
import com.app.repo.ThucDonRepo;
import com.app.service.ThucDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThucDonServiceImpl implements ThucDonService {

    @Autowired
    ThucDonRepo thucDonRepo;

    @Autowired
    NhomRepo nhomRepo;

    @Override
    public List<ThucDon> findAll() {
        return thucDonRepo.findAll();
    }

    @Override
    public List<ThucDonResponse> responseFindAll() {
        List<ThucDon> listThucDon = thucDonRepo.findAll();
        List<ThucDonResponse> thucDonResponses = new ArrayList<>();

        for (int i = 0; i < listThucDon.size(); i++) {
            Nhom nhom = nhomRepo.findById(listThucDon.get(i).getNhom_id())
                    .orElseThrow(() -> new NhomNotFoundException("Không tìm thấy tên nhóm của thực đơn!"));

            ThucDonResponse thucDonResponse = ThucDonResponse.builder()
                    .id(listThucDon.get(i).getId())
                    .description(listThucDon.get(i).getDescription())
                    .discountPercent(listThucDon.get(i).getDiscountPercent())
                    .priceAfterDiscount(listThucDon.get(i).getPriceAfterDiscount())
                    .status(listThucDon.get(i).getStatus())
                    .image(listThucDon.get(i).getImage())
                    .name(listThucDon.get(i).getName())
                    .price(listThucDon.get(i).getPrice())
                    .nhom(nhom)
                    .build();

            thucDonResponses.add(thucDonResponse);
        }

        return thucDonResponses.size() > 0 ? thucDonResponses : null;
    }

    @Override
    public ThucDonResponse findById(Long id) {
        ThucDon thucDon = thucDonRepo.findById(id)
                .orElseThrow(() -> new ThucDonNotFoundException("Không tìm thấy thực đơn với id: " + id));

        Nhom nhom = nhomRepo.findById(thucDon.getNhom_id())
                .orElseThrow(() -> new NhomNotFoundException("Không tìm thấy tên nhóm của thực đơn!"));

        return ThucDonResponse.builder()
                .id(thucDon.getId())
                .description(thucDon.getDescription())
                .discountPercent(thucDon.getDiscountPercent())
                .priceAfterDiscount(thucDon.getPriceAfterDiscount())
                .status(thucDon.getStatus())
                .image(thucDon.getImage())
                .name(thucDon.getName())
                .price(thucDon.getPrice())
                .nhom(nhom)
                .build();
    }

}
