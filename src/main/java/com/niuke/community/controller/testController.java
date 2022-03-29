package com.niuke.community.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("controller")
public class testController {

    @GetMapping ("hello")
    @ResponseBody
    public String sayHello(){

        return "张涛~你好``````````";
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getMethod());
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>牛客网~~~<h1>");

    }
    @RequestMapping(value = "/limit" ,method = RequestMethod.POST)
    @ResponseBody
    public String limit(HttpServletRequest request, HttpServletResponse response,String name,int age,String bbb) throws IOException {
        return name+"--"+age+"--"+bbb;

    }
}
