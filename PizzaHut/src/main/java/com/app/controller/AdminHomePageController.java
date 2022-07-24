package com.app.controller;

import com.app.entity.Combo;
import com.app.entity.ThucDon;
import com.app.service.ComboService;
import com.app.service.ThucDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminHomePageController {

    @Autowired
    ThucDonService thucDonService;

    @Autowired
    ComboService comboService;

    @GetMapping("/admin")
    public String showAdminHomePage(Model model) {
        model.addAttribute("listComboResponse", comboService.responseFindAll());
        model.addAttribute("listThucDonResponse", thucDonService.responseFindAll());
        return "/admin_index";
    }

}
