package com.nag.controller;

import com.nag.model.Vet;
import com.nag.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class VetController {

    @Autowired
    private VetService vetService;

    @RequestMapping({"/vets","/vets.html"})
    public String getListOfVets(Model model)
    {
        Set<Vet> vets = vetService.findAll();
        model.addAttribute("vets",vets);
        return "vets/index";
    }
}
