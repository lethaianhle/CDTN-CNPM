package com.app.repo;

import com.app.entity.Role;
import com.app.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepoTest {

    @Autowired
    UserRepo userRepo;

    @Test
    void initData() {
//        User user = new User();
//        user.setAddress("Kim Quan, Thạch Thất, Hà Nội");
//        user.setBod("26/12/2000");
//        user.setEmail("lethaianh@gmail.com");
//        user.setName("Lê Thái Anh");
//        user.setPhone("0979842998");
//        user.setPassword("123456");
//        user.setRole_id(Role.USER.getId());
//        userRepo.save(user);
//
//        User user2 = new User();
//        user2.setAddress("Quận 7, Thủ Đức, HCM");
//        user2.setBod("12/12/1999");
//        user2.setEmail("thanhnguyen@gmail.com");
//        user2.setName("Nguyễn Thế Thành");
//        user2.setPhone("01645333628");
//        user2.setPassword("123456");
//        user2.setRole_id(Role.USER.getId());
//        userRepo.save(user2);

        User admin = new User();
        admin.setId(3L);
        admin.setAddress("Administrator");
        admin.setBod("08/10/1997");
        admin.setEmail("admin@gmail.com");
        admin.setName("Admin");
        admin.setPhone("0383838888");
        admin.setPassword("123456");
        admin.setRole_id(Role.ADMIN.getId());
        userRepo.save(admin);
    }

}