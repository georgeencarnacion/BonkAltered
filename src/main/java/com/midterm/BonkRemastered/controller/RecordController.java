package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.ProductDTO;
import com.midterm.BonkRemastered.dto.RecordDTO;
import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.repository.RecordRepository;
import com.midterm.BonkRemastered.services.BusinessService;
import com.midterm.BonkRemastered.services.ProductService;
import com.midterm.BonkRemastered.services.RecordService;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/{id}")
    private String list(@PathVariable Long id, Model model) {

        model.addAttribute("user", userService.get(id));
        model.addAttribute("record", new RecordDTO());
        return "product/view-record";
    }

    @GetMapping("/expense")
    private String getProductAddForm( Model model) {
        model.addAttribute("record", new RecordDTO());
        return "product/add-expenses";
    }
    //this is for the expense
    @PostMapping("/{id}")
    private String add(@Valid @ModelAttribute("product") @PathVariable Long id,  RecordDTO record, Model model) {

        record.setUser(id);

        record.setMonth(new SimpleDateFormat("MMM").format(Calendar.getInstance().getTime()));
        record.setCogs(0);
        record.setRevenue(0);
        record.setNetProfit(0);

        recordService.add(record);

        return list(id, model);
    }

    @GetMapping("/{id}/compute")
    private String getCompute(@PathVariable Long id, Model model) {
        model.addAttribute("record", recordService.get(id));
        return "product/view-expense";
    }

    @PutMapping("/{id}")
    private String update(@PathVariable Long id, RecordDTO record, Model model) {

        record.setUser(id);
        recordService.update(record);
        return list(id, model);

    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable Long id, RecordDTO record) {
        record.setUser(id);
        recordService.delete(record.getRecordId());
        return "product/delete-route";
    }



}