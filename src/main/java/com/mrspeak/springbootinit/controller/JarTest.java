package com.mrspeak.springbootinit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author allinibridge
 * @description webjars测试
 * @date 2019/8/13
 */
@Controller
public class JarTest {

    @RequestMapping({"/ind","login.html"})
    public String index(){
        return "login";
    }

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String ,Object> map,HttpSession session){
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)){
            session.setAttribute("user",username);
            return "redirect:/dashboard";
        }else{
            map.put("msg","用户名或密码错误！！");
            return "login";
        }

    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/userList")
    public String userList(){
        return "list";
    }
}
