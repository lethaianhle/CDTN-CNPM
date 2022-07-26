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
        AtomicReference<Double> priceExpected = new AtomicReference<>((double) 0); // khai báo biến tạm sum = 0;
        List<ThucDon> thucDonList = comboThucDonRepo.findAllThucDonByComboId(2L); // danh sách thực đơn trong combo
        thucDonList.forEach(thucDon -> priceExpected.updateAndGet(v -> (double) (v + thucDon.getPrice()))); // tính toongr tiền = tổng giá tiền thực đơn trong combo -> sum

        double totalPrice = comboThucDonRepo.totalPriceByComboId(2L); // trả về giá trị thực tế của tổng tiền combo
        log.info("Total Price In Combo Id 2:" + totalPrice + " - Price Expected: " + priceExpected.get());
        assertEquals(totalPrice, priceExpected.get()); // passed, faild
    }

}