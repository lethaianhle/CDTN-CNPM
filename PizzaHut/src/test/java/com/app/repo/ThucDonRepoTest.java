package com.app.repo;

import com.app.entity.Status;
import com.app.entity.ThucDon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThucDonRepoTest {

    @Autowired
    ThucDonRepo thucDonRepo;

    @Test
    void testUtf8() {

    }

    @Test
    void initData() {
        ThucDon thucDon = new ThucDon();
        thucDon.setStatus(Status.NGUNG_PHUC_VU.getName());
        thucDon.setName("Mì Ý Bolognese");
        thucDon.setImage("no images");
        thucDon.setNhom_id(1L);
        thucDon.setPrice(45_000.000);
        thucDon.setDiscountPercent(10);
        thucDon.setPriceAfterDiscount(thucDon.getPrice() - (thucDon.getPrice() * thucDon.getDiscountPercent() / 100));
        thucDon.setDescription("Mì Ý ăn kèm với sốt Bolognese không chỉ tạo nên sự kết hợp vô cùng hoàn hảo mà còn là món ăn cực kì dễ làm.");
        thucDonRepo.save(thucDon);

        ThucDon thucDon2 = new ThucDon();
        thucDon2.setStatus(Status.AVAILABLE.getName());
        thucDon2.setName("Mỳ Ý Spaghetti");
        thucDon2.setImage("no images");
        thucDon2.setNhom_id(3L);
        thucDon2.setPrice(65_000.000);
        thucDon2.setDiscountPercent(0);
        thucDon2.setPriceAfterDiscount(thucDon.getPrice() - (thucDon.getPrice() * (thucDon.getDiscountPercent() / 100)));
        thucDon2.setDescription("Spaghetti, hay thường được gọi là mì Ý, là một loại pasta sợi dài, nhỏ, hình trụ. Nó là một loại thực phẩm thiết yếu của nền ẩm thực Ý truyền thống.");
        thucDonRepo.save(thucDon2);
    }

}