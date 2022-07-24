package com.app.dao.response;

import com.app.entity.Nhom;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThucDonResponse {

    private Long id;

    private String name;

    private String image;

    private String description;

    private String status;

    private double price;

    private double discountPercent;

    private double priceAfterDiscount;

    private Nhom nhom;

}
