package com.app.repo;

import com.app.entity.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepo extends JpaRepository<Combo, Long> {
}
