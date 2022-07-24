package com.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "thuc_don")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ThucDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private String description;

    private String status;

    private double price;

    private double discountPercent;

    private double priceAfterDiscount;

    private Long nhom_id;

}
