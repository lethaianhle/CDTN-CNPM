package com.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "combo_thucdon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Combo_ThucDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long thucDonId;

    private Long comboId;

}
