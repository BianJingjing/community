package com.xiaobian.community.controller;

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
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest,
                        Model model){
        //检验登录状态
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length !=0){
            for (Cookie cookie:cookies) {
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user !=null){
                        httpServletRequest.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }
}
