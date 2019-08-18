package com.mrspeak.springbootinit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@ResponseBody
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!!";
    }

    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add");
        mv.addObject("hello","你好");
        return mv;
    }




}
