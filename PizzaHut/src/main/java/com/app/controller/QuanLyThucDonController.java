package com.app.controller;

import com.app.service.ThucDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuanLyThucDonController {

    @Autowired
    ThucDonService thucDonService;

    @GetMapping("/admin/thucdon")
    public String showQuanLyThucDonForm(Model model) {
        model.addAttribute("listThucDonResponse", thucDonService.responseFindAll());
        return "admin_quanlythucdon";
    }

}
