package com.app.repo;

import com.app.entity.Combo;
import com.app.entity.Combo_ThucDon;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ComboRepoTest {

    @Autowired
    ComboRepo comboRepo;

    @Autowired
    ComboThucDonRepo comboThucDonRepo;

    @Test
    void initData() {
        Combo combo = new Combo();
        combo.setId(2L);
        combo.setImage("no images");
        combo.setName("Thêm bạn thêm ngon");
        combo.setDescription("Dành cho 02 người: 01 Pizza Bò, 01 Mỳ Ý Spaghetti + 02 Lon Coca Cola/Trà Sữa.");
        combo.setDiscountPercent(10);
        combo.setTotalPrice(comboThucDonRepo.totalPriceByComboId(2L));
        combo.setPriceAfterDiscount(combo.getTotalPrice() - (combo.getTotalPrice() * (combo.getDiscountPercent() / 100)));
        Combo comboCreated = comboRepo.save(combo);

//        Combo_ThucDon comboThucDon = new Combo_ThucDon();
//        comboThucDon.setComboId(comboCreated.getId());
//        comboThucDon.setThucDonId(3L);
//        comboThucDonRepo.save(comboThucDon);
//
//        Combo_ThucDon comboThucDon2 = new Combo_ThucDon();
//        comboThucDon2.setComboId(comboCreated.getId());
//        comboThucDon2.setThucDonId(9L);
//        comboThucDonRepo.save(comboThucDon2);
//
//        Combo_ThucDon comboThucDon3 = new Combo_ThucDon();
//        comboThucDon3.setComboId(comboCreated.getId());
//        comboThucDon3.setThucDonId(5L);
//        comboThucDonRepo.save(comboThucDon3);


    }

}