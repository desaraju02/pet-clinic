package com.nag.controller;

import com.nag.model.Owner;
import com.nag.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller

public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping("/owners")
    public String getListOfOwners(Model model)
    {
        Set<Owner> ownersSet = ownerService.findAll();
        model.addAttribute("owners", ownersSet);
        return "owners/index";
    }
}
