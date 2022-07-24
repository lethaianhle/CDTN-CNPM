package com.app.repo;

import com.app.entity.Combo_ThucDon;
import com.app.entity.ThucDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComboThucDonRepo extends JpaRepository<Combo_ThucDon, Long> {

    @Query(value = "SELECT td FROM ThucDon td " +
            "INNER JOIN Combo_ThucDon cbtd " +
            "ON cbtd.thucDonId=td.id " +
            "WHERE cbtd.comboId = ?1")
    List<ThucDon> findAllThucDonByComboId(Long id);

    @Query(value = "SELECT td.name FROM ThucDon td " +
            "INNER JOIN Combo_ThucDon cbtd " +
            "ON cbtd.thucDonId=td.id " +
            "WHERE cbtd.comboId = ?1")
    List<String> findAllNameThucDonByComboId(Long id);

    @Query(value = "SELECT SUM(td.price) FROM ThucDon td " +
            "INNER JOIN Combo_ThucDon cbtd " +
            "ON cbtd.thucDonId=td.id " +
            "WHERE cbtd.comboId = ?1")
    double totalPriceByComboId(Long id);

}
