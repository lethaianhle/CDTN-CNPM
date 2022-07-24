package com.app.entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Role {

    ADMIN(0L, "administrator"),

    USER(1L, "user");

    private Long id;

    private String name;

}
