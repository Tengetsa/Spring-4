package com.example.demo.controllers;

import com.example.demo.domain.DataEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    @RequestMapping("/task1")
    public String task1(Model model) {
        String helloWorld = "Привет, мир!";
        model.addAttribute("helloWorld", helloWorld);
        return "task1";
    }

    @GetMapping("/task2")
    public String task2(Model model) {
        String[] ownerCar = db();
        model.addAttribute("Stamp", ownerCar[0]);
        model.addAttribute("Age", ownerCar[1]);
        model.addAttribute("Owner", ownerCar[2]);
        return "task2";
    }

    @GetMapping("/task3")
    public String task3(Model model) {
        model.addAttribute("input", new DataEntry());
        return "task3";
    }

    @PostMapping("/task3")
    public String formSubmit(@RequestParam String input, Model model) {
        String[] ownerCar = db();
        model.addAttribute("Stamp", ownerCar[0]);
        model.addAttribute("Age", ownerCar[1]);
        model.addAttribute("Owner", input);

        return "task3Result";
    }

    public String[] db() {
        return new String[]{"BMW", "1997", "Ivan"};
    }
}
