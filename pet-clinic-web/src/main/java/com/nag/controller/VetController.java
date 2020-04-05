package com.nag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {


    @RequestMapping("/vets")
    public String getListOfVets(Model model)
    {
        return "vets/index";
    }
}
