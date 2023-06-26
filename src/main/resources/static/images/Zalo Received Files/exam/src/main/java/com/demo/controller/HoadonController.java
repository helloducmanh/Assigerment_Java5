package com.demo.controller;

import com.demo.entity.HoaDon;
import com.demo.repo.HoadonRepo;
import com.demo.repo.KhachhangRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class HoadonController {
    @Getter @Setter
    public static class Search{
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fromDate;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date toDate;
    }
    @Autowired
    HoadonRepo hoadonRepo;
    @Autowired
    KhachhangRepo khachhangRepo;
    @GetMapping("/hoadon/hienthi")
    public String hienthiHD(Model model, @ModelAttribute("search") Search search)
    {        HoaDon item = new HoaDon();
        model.addAttribute("item",item);
        List<HoaDon> list = hoadonRepo.findAll();
        model.addAttribute("listHD",list);
        model.addAttribute("listKH",khachhangRepo.findAll());

        return "hoadon/index";
    }
    @PostMapping("/hoadon/hienthi")
    public String timHD(Model model, @ModelAttribute("search") Search search){
        List<HoaDon> list1 = hoadonRepo.searchByNgaylap(search.fromDate,search.toDate);
        model.addAttribute("listHD",list1);
        return "hoadon/index";
    }

    @RequestMapping("/hoadon/detail/{mahoadon}")
    public String detailHD(Model model, @PathVariable("mahoadon") Long mahoadon){
        HoaDon item = hoadonRepo.findById(mahoadon).get();
        model.addAttribute("item",item);
        List<HoaDon> list = hoadonRepo.findAll();
        model.addAttribute("listHD",list);
        model.addAttribute("listKH",khachhangRepo.findAll());
        return "hoadon/update";
    }
    @RequestMapping("/hoadon/remove/{mahoadon}")
    public String addHD(Model model,@PathVariable("mahoadon") Long mahoadon){
        hoadonRepo.deleteById(mahoadon);
        return "redirect:/hoadon/hienthi";
    }
    @RequestMapping("/hoadon/update/{mahoadon}")
    public String updateHD(Model model, @PathVariable("mahoadon") Long mahoadon,
                           @ModelAttribute("item") HoaDon item){
        hoadonRepo.save(item);
        return "redirect:/hoadon/hienthi";
    }
}
