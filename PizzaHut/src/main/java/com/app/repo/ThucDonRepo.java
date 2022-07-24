package com.app.repo;

import com.app.entity.ThucDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThucDonRepo extends JpaRepository<ThucDon, Long> {
}
