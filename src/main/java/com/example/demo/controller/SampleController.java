package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(){
        log.info("hi...samkim");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age){
        log.info("ex1...... samkim");
        log.info(name+" "+age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name= "name", defaultValue = "samKim") String name,
                @RequestParam(name="age", defaultValue = "15") int age){
        log.info("ex2.....samkim");
        log.info(name+"  "+age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3.......");
        log.info(dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("ex4.......");
        model.addAttribute("message", "Check how to use Model object");
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("name", "ABC");
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){

    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2){
        log.info("p1........"+p1);
        log.info("p2........"+p2);

    }
}
