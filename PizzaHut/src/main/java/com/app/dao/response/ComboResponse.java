package com.app.dao.response;

import com.app.entity.ThucDon;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComboResponse {

    private Long id;

    private String name;

    private String image;

    private String description;

    private double totalPrice;

    private double discountPercent;

    private double priceAfterDiscount;

    private List<ThucDon> listThucDon;

    private List<String> listNameThucDon;

}
