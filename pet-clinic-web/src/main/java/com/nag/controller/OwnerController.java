package com.nag.controller;

import com.nag.model.Owner;
import com.nag.model.Pet;
import com.nag.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping({"/",""})
    public String getListOfOwners(Model model)
    {
        Set<Owner> ownersSet = ownerService.findAll();
        model.addAttribute("owners", ownersSet);
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners()
    {
        return "notimplemented";
    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = ownerService.findById(ownerId);
//        for (Pet pet : owner.getPets()) {
//            pet.setVisitsInternal(visits.findByPetId(pet.getId()));
//        }
        mav.addObject(owner);
        return mav;
    }

}
