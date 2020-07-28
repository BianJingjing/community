package com.xiaobian.community.controller;

import com.xiaobian.community.dto.PaginationDTO;
import com.xiaobian.community.mapper.UserMapper;
import com.xiaobian.community.model.User;
import com.xiaobian.community.service.NotificationServier;
import com.xiaobian.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private NotificationServier notificationServier;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest httpServletRequest,
                          @PathVariable(name = "action") String action,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "2") Integer size,
                          Model model){

        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }
        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
            PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("pagination",paginationDTO);
        }else if ("replies".equals(action)){
            PaginationDTO paginationDTO = notificationServier.list(user.getId(),page,size);
            Long unreadCount = notificationServier.unreadCount(user.getId());
            model.addAttribute("pagination",paginationDTO);
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }



        return "profile";
    }
}
