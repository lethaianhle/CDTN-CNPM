package com.app.controller;

import com.app.entity.Nhom;
import com.app.service.NhomService;
import com.app.service.ThucDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    NhomService nhomService;

    @Autowired
    ThucDonService thucDonService;

    @GetMapping("")
    public String showHomePage(Model model) {
        model.addAttribute("listNhom", nhomService.findAll());
        model.addAttribute("listThucDon", thucDonService.findAll());
        return "homepage_index";
    }

}
