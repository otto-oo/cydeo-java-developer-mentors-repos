package com.cydeo.controller;

import com.cydeo.bootstrap.MentorData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String getMentorPage(Model model) {
        model.addAttribute("mentors", MentorData.getAll());
        return "mentor/mentorTable";
    }

    @RequestMapping("/info/{make}/{year}")
    public String getCarInfo(@PathVariable String make, @PathVariable int year){
        System.out.println(make);
        System.out.println(year);
        return "home";
    }

}
