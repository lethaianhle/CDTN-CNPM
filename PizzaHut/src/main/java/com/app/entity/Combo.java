package com.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "combo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private String description;

    private double totalPrice;

    private double discountPercent;

    private double priceAfterDiscount;

}
