package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Status {

    NGUNG_PHUC_VU(0L, "Ngừng phục vụ"),

    AVAILABLE(1L, "Available");

    private Long id;

    private String name;

}
