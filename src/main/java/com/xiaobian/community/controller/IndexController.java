package com.xiaobian.community.controller;

import com.xiaobian.community.dto.PaginationDTO;
import com.xiaobian.community.dto.QuestionDTO;
import com.xiaobian.community.mapper.QuestionMapper;
import com.xiaobian.community.mapper.UserMapper;
import com.xiaobian.community.model.Question;
import com.xiaobian.community.model.User;
import com.xiaobian.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "2") Integer size
                        ){

        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
