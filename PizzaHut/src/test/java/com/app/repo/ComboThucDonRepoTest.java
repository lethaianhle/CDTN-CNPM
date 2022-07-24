package com.app.repo;

import com.app.entity.ThucDon;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class ComboThucDonRepoTest {

    @Autowired
    ComboThucDonRepo comboThucDonRepo;

    @Autowired
    ThucDonRepo thucDonRepo;

    @Test
    void testFindAllThucDonByComboId() {
        List<ThucDon> thucDonList = comboThucDonRepo.findAllThucDonByComboId(2L);
        thucDonList.forEach(thucDon -> log.info(thucDon.toString()));
    }

    @Test
    void testTotalPriceByComboId() {
        AtomicReference<Double> priceExpected = new AtomicReference<>((double) 0);
        List<ThucDon> thucDonList = comboThucDonRepo.findAllThucDonByComboId(2L);
        thucDonList.forEach(thucDon -> priceExpected.updateAndGet(v -> (double) (v + thucDon.getPrice())));

        double totalPrice = comboThucDonRepo.totalPriceByComboId(2L);
        log.info("Total Price In Combo Id 2:" + totalPrice + " - Price Expected: " + priceExpected.get());
        assertEquals(totalPrice, priceExpected.get());
    }

}