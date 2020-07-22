package com.xiaobian.community.controller;

import com.xiaobian.community.dto.QuestionDTO;
import com.xiaobian.community.mapper.QuestionMapper;
import com.xiaobian.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(value = "id") Long id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
