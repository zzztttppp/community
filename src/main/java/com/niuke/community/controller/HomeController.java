package com.niuke.community.controller;

import com.niuke.community.entity.DiscussPost;
import com.niuke.community.entity.Page;
import com.niuke.community.entity.User;
import com.niuke.community.service.DiscussPostService;
import com.niuke.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //方法调用钱,SpringMvc会自动实例化Model和Page,并将Page注入Model.
        //所以，在thymeleaf中可以直接访问Page对象中的数据.
        page.setRows(discussPostService.findDiscussPostRows(111));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(111,page.getOffset(),page.getLimit(),1);
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if(list!=null){
            for (DiscussPost post : list) {
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "index";
    }

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("msg", "Hello , world !");
        List<DiscussPost> list = discussPostService.findDiscussPosts(149,0,5,1);
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if(list!=null){
            for (DiscussPost post : list) {
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        modelMap.addAttribute("discussPosts",discussPosts);
        return "index1";
    }
}
