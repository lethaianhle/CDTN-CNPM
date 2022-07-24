package com.app.repo;

import com.app.entity.Nhom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NhomRepoTest {

    @Autowired
    NhomRepo nhomRepo;

    @Test
    void testUtf8() {
        Nhom nhom = new Nhom();
        nhom.setName("Mỳ Ý");
        Nhom createdNhom = nhomRepo.save(nhom);
        assertNotNull(createdNhom);
    }

}