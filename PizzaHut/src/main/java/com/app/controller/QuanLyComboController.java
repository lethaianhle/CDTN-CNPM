package com.app.controller;

import com.app.service.ComboService;
import com.app.service.ThucDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class QuanLyComboController {

    @Autowired
    ComboService comboService;

    @Autowired
    ThucDonService thucDonService;

    @GetMapping("/admin/combo")
    public String showQuanLyComboForm(Model model) {
        model.addAttribute("listComboResponse", comboService.responseFindAll());
        return "admin_quanlycombo";
    }

    @GetMapping("/admin/combo/themmoi")
    public String showThemMoiComboForm(Model model) {
        model.addAttribute("pageTitle", "Thêm mới combo");
        model.addAttribute("listThucDon", thucDonService.findAll());
        return "admin_formcombo";
    }

    @GetMapping("/admin/combo/view/{id}")
    public String showChiTietComboForm(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết combo");
        model.addAttribute("listThucDon", thucDonService.findAll());
        return "admin_formcombo";
    }

}
