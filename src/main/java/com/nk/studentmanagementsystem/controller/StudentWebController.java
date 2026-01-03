package com.nk.studentmanagementsystem.controller;

import com.nk.studentmanagementsystem.beans.Student;
import com.nk.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
        return "stdList";
    }

    @GetMapping("/view/{id}")
    public String viewPage(@PathVariable Long id, Model model) {
        var s = service.findById(id).orElse(null);
        if (s == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", s);
        return "view";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes redirectAttributes){
        try {
            service.create(student);

            redirectAttributes.addFlashAttribute(
                    "msg",
                    "Student added successfully"
            );

            return "redirect:/students";
        }catch(Exception e) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    e.getMessage());
            return "redirect:/students";
        }
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        var s = service.findById(id).orElse(null);
        if (s == null) {
            return "redirect:/students";
        }else {
            service.update(id, s);
            model.addAttribute("msg", "Student updated successfully");
            return "success";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        var s = service.findById(id).orElse(null);
        if (s == null) {
            return "redirect:/students";
        }
        service.delete(id);
        return "redirect:/students";
    }
}