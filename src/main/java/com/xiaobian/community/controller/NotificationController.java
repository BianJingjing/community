package com.xiaobian.community.controller;

import com.xiaobian.community.dto.NotificationDTO;
import com.xiaobian.community.dto.PaginationDTO;
import com.xiaobian.community.enums.NotificationTypeEnum;
import com.xiaobian.community.model.User;
import com.xiaobian.community.service.NotificationServier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationServier notificationServier;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest httpServletRequest,
                          @PathVariable(name = "id") Long id){

        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }
        NotificationDTO notificationDTO = notificationServier.read(id,user);
        if (NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()
                || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()){
            return "redirect:/question/" + notificationDTO.getOuterid();
        } else {
            return "redirect:/";
        }

    }
}
