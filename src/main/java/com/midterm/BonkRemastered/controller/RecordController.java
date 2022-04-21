package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.ProductDTO;
import com.midterm.BonkRemastered.dto.RecordDTO;
import com.midterm.BonkRemastered.dto.UserDTO;
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

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    @GetMapping("/{id}")
    private String list(@PathVariable Long id, Model model) {

        model.addAttribute("user", userService.get(id));
        model.addAttribute("product", new RecordDTO());
        return "product/view-record";
    }

    @GetMapping("/add")
    private String getProductAddForm( Model model) {
        model.addAttribute("product", new ProductDTO());
        return "product/add-expenses";
    }

    @PostMapping("/{id}")
    private String add(@Valid @ModelAttribute("product") @PathVariable Long id,  RecordDTO record, BindingResult bindingResult, Model model) {

        record.setUser(id);
        recordService.add(record);
        return list(id, model);
    }

    @GetMapping("/{id}/view")
    private String get(@PathVariable Long id, Model model) {
        model.addAttribute("product", recordService.get(id));
        return "product/view-expenses";
    }

    @PutMapping("/{id}")
    private String update(@PathVariable Long id, RecordDTO record, Model model) {

        record.setUser(id);
        recordService.update(record);
        return list(id, model);
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable Long id, RecordDTO record, Model model) {
        record.setUser(id);
        recordService.delete(record.getRecordId());
        return list(id, model);
    }
}
