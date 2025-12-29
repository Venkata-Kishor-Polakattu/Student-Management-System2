package com.nk.studentmanagementsystem.controller;

import com.nk.studentmanagementsystem.beans.Student;
import com.nk.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    private final StudentService service;

    public StudentWebController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("students", service.listAll());
        return "students/list";
    }

    @GetMapping("/view/{id}")
    public String viewPage(@PathVariable Long id, Model model) {
        var s = service.findById(id).orElse(null);
        if (s == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", s);
        return "students/view";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "StudentForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldError().getDefaultMessage());
            return "Error";
        }
        try {
            if (student.getId() == null) {
                service.create(student);
            } else {
                service.update(student.getId(), student);
            }
            return "redirect:/students";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "Error";
        }
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        var s = service.findById(id).orElse(null);
        if (s == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", s);
        return "students/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students";
    }
}