package com.app.controller;

import com.app.dao.response.ThucDonResponse;
import com.app.entity.Nhom;
import com.app.entity.Status;
import com.app.entity.ThucDon;
import com.app.repo.NhomRepo;
import com.app.repo.ThucDonRepo;
import com.app.service.ThucDonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class QuanLyThucDonController {

    @Autowired
    ThucDonService thucDonService;

    @Autowired
    ThucDonRepo thucDonRepo;

    @Autowired
    NhomRepo nhomRepo;

    @GetMapping("/admin/thucdon")
    public String showQuanLyThucDonForm(Model model) {
        model.addAttribute("listThucDonResponse", thucDonService.responseFindAll());
        return "admin_quanlythucdon";
    }

    @GetMapping("/admin/thucdon/view/{id}")
    public String showChiTietThucDonForm(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes, Model model) {
        List<String> nhomName = new ArrayList<>();
        List<Nhom> nhoms = nhomRepo.findAll();
        for (int i = 0; i < nhoms.size(); i++) {
            nhomName.add(nhoms.get(i).getName());
        }

        ThucDonResponse thucDonRes = thucDonService.findById(id);
        model.addAttribute("thucDonRes", thucDonRes);
        List<Status> listStatus = List.of(Status.values());
        model.addAttribute("listStatus", listStatus);
        model.addAttribute("pageTitle", "Chi tiết thực đơn");
        model.addAttribute("nhoms", nhoms);
        model.addAttribute("listNhomName", nhomName);
        return "admin_formthucdon";
    }

    @GetMapping("/admin/thucdon/themmoi")
    public String showThemMoiThucDonForm(RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("pageTitle", "Thêm mới thực đơn");
        List<Status> listStatus = List.of(Status.values());
        model.addAttribute("listStatus", listStatus);
        model.addAttribute("listNhom", nhomRepo.findAll());
        model.addAttribute("thucDonRes", ThucDonResponse.builder().build());
        return "admin_formthucdon";
    }

    @PostMapping("/admin/thucdon/save")
    public String save(@ModelAttribute(name = "thucDonRes") ThucDonResponse thucDonRes,
                                         RedirectAttributes redirectAttributes,
                                         Model model) {
        try {
            log.info(thucDonRes.toString());
            ThucDon thucDon = new ThucDon();
            thucDon.setId(thucDonRes.getId());
            thucDon.setName(thucDonRes.getName());
            thucDon.setImage("no images");
            thucDon.setDescription(thucDonRes.getDescription());
            thucDon.setStatus(thucDonRes.getStatus());
            thucDon.setPrice(thucDonRes.getPrice());
            thucDon.setDiscountPercent(thucDonRes.getDiscountPercent());
            thucDon.setPriceAfterDiscount(thucDon.getPriceAfterDiscount());
            thucDon.setNhom_id(1L);

            thucDonRepo.save(thucDon);
            redirectAttributes.addFlashAttribute("message", "Lưu thành công thực đơn!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/admin/thucdon";
    }

    @GetMapping("/admin/thucdon/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes, Model model) {
        try {
            thucDonRepo.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công thực đơn id: " + id);
        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("message", "Thao tác thất bại! " + exception.getMessage());
        }
        return "redirect:/admin/thucdon";
    }

}
