package com.example.demo.controller;

import com.example.demo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(){
        log.info("todo list.... samkim");
    }

    @GetMapping(value = "/register")
    public void registerGet(){
        log.info("todo registerGet.... samkim");
    }

    @PostMapping(value = "register")
    public void registerPost(TodoDTO todoDTO){
        log.info("todo registerPost....samkim");
        log.info(todoDTO);
    }
}
