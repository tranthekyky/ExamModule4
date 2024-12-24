package com.exam.ExamModule4.controller;


import com.exam.ExamModule4.model.Category;
import com.exam.ExamModule4.model.Customer;
import com.exam.ExamModule4.model.Transaction;
import com.exam.ExamModule4.service.CategoryService;
import com.exam.ExamModule4.service.CustomerService;
import com.exam.ExamModule4.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final CategoryService categoryService;

    @ModelAttribute("customers")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }
    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/table");
        modelAndView.addObject("transactions", transactionService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("transactions", new Transaction());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("transactions") Transaction transaction , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/create");
        }
        transactionService.save(transaction);
        return new ModelAndView("redirect:/transactions/list");
    }
}
