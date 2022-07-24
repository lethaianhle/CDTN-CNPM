package com.app.repo;

import com.app.entity.Nhom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhomRepo extends JpaRepository<Nhom, Long> {
}
