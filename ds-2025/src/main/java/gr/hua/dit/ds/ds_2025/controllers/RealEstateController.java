package gr.hua.dit.ds.ds_2025.controllers;

import gr.hua.dit.ds.ds_2025.entities.RealEstate;
import gr.hua.dit.ds.ds_2025.services.RealEstateService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("realestate")
public class RealEstateController {

    private RealEstateService realEstateService;

    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @RequestMapping()
    public String showRealEstates(Model model) {
        model.addAttribute("realestates", realEstateService.getRealEstates());
        return "realestate/realestates";
    }

    @GetMapping("/{id}")
    public String showRealEstate(@PathVariable Integer id, Model model){
        RealEstate realestate = realEstateService.getRealEstate(id);
        model.addAttribute("realestates", realestate);
        return "realestate/realestates";
    }

    @GetMapping("/new")
    public String addRealEstate(Model model){
        RealEstate realestate = new RealEstate();
        model.addAttribute("realestate", realestate);
        return "realestate/realestate";
    }

    @PostMapping("/new")
    public String saveRealEstate(@Valid @ModelAttribute("realestate") RealEstate realestate, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            System.out.println("error");
            return "realestate/realestate";
        } else {
            realEstateService.saveRealEstate(realestate);
            model.addAttribute("realestates", realEstateService.getRealEstates());
            model.addAttribute("successMessage", "Real Estate added successfully!");
            return "realestate/realestates";
        }
    }
}