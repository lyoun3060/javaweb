package com.example.demo.controller;

import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;


    @GetMapping(value = "/register")
    public void registerGet(){
        log.info("todo registerGet.... samkim");
    }

    @PostMapping(value = "/register")
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("todo registerPost....samkim");
        log.info(todoDTO);

        if(bindingResult.hasErrors()){
            log.info("has error");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return  "redirect:/todo/register";
        }

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){

        log.info("todo list가져오기");

//        model.addAttribute("dtoList", todoService.getAll());
        log.info(pageRequestDTO);
        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    @GetMapping(value = {"/read", "modify"})
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping(value = "modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.info("modify has error");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);
        todoService.modify(todoDTO); //DTO로 받아온 데이터를 서비스에서 VO로 변환시켜서 사용함
        return "redirect:/todo/list";
    }

    @PostMapping(value = "/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){
        log.info("----------remove----------");
        log.info("tno:  "+tno);

        todoService.delete(tno);

        return "redirect:/todo/list";
    }
}
