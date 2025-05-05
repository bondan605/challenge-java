package com.codeid.eshopper.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeid.eshopper.model.Employee;
import com.codeid.eshopper.service.CategoryService;

@Controller
@RequestMapping("index")
public class IndexController {

    private final CategoryService categoryService;

    public IndexController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("category", categoryService.findAllCategory());
        return "index";
    }

    @GetMapping("/employee")
    public String showEmployee(Model model) {
        model.addAttribute("category", categoryService.findAllCategory());
        var emp1 = new Employee("Widi", LocalDate.of(2025, 1, 1), 4_000);
        var emp2 = new Employee("Hanip", LocalDate.of(2025, 1, 1), 5_000);

        var emps = Arrays.asList(emp1, emp2);

        model.addAttribute("employees", emps);

        return "employee";
    }

}
