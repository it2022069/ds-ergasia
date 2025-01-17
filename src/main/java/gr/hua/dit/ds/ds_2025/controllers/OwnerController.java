package gr.hua.dit.ds.ds_2025.controllers;

import gr.hua.dit.ds.ds_2025.entities.Owner;
import gr.hua.dit.ds.ds_2025.entities.RealEstate;
import gr.hua.dit.ds.ds_2025.services.OwnerService;
import gr.hua.dit.ds.ds_2025.services.RealEstateService;
import gr.hua.dit.ds.ds_2025.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("owner")
public class OwnerController {

    private UserService userService;

    private OwnerService ownerService;

    private RealEstateService realEstateService;

    public OwnerController(RealEstateService realEstateService, OwnerService ownerService, UserService userService) {
        this.realEstateService = realEstateService;
        this.ownerService = ownerService;
        this.userService = userService;
    }

    @RequestMapping()
    public String showMyRealEstates(Model model) {
        return "realestate/owner";
    }
}