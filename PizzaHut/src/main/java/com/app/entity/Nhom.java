package com.app.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nhom")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Nhom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Nhom nhom = (Nhom) o;
        return id != null && Objects.equals(id, nhom.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
