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
        model.addAttribute("realestate", realestate);
        return "realestate/tenancy";
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

    @GetMapping("/delete/{id}")
    public String deleteRealEstate(@PathVariable Integer id, Model model){
        RealEstate realestate = realEstateService.getRealEstate(id);
        realEstateService.deleteRealEstate(realestate);
        model.addAttribute("realestates", realEstateService.getRealEstates());
        return "realestate/realestates";
    }

    @GetMapping("/rent/{id}")
    public String rentRealEstate(@PathVariable Integer id, Model model){
        RealEstate realestate = realEstateService.getRealEstate(id);
        realestate.setRented(true);
        model.addAttribute("realestates", realEstateService.getRealEstates());
        return "realestate/realestates";
    }

    @GetMapping("/rentout/{id}")
    public String rentoutRealEstate(@PathVariable Integer id, Model model){
        RealEstate realestate = realEstateService.getRealEstate(id);
        realestate.setRented(false);
        model.addAttribute("realestates", realEstateService.getRealEstates());
        return "realestate/realestates";
    }

    @GetMapping("/edit/{id}")
    public String editRealEstate(@PathVariable Integer id, Model model){
        RealEstate realestate = realEstateService.getRealEstate(id);
        model.addAttribute("realestate", realestate);
        return "realestate/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateRealEstate(@PathVariable Integer id, @Valid @ModelAttribute("realestate") RealEstate realestate, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "realestate/edit";
        }
        realEstateService.updateRealEstate(realestate);
        model.addAttribute("realestate", realestate);
        return "realestate/tenancy";
    }

    @GetMapping("/shownotapproved")
    public String showNotApprovedRealEstates(Model model) {
        model.addAttribute("realestates", realEstateService.getRealEstates());
        return "realestate/notapproved";
    }

    @GetMapping("/approve/{id}")
    public String approveRealEstate(@PathVariable Integer id, Model model){
        RealEstate realestate = realEstateService.getRealEstate(id);
        realestate.setStatus(true);
        model.addAttribute("realestates", realEstateService.getRealEstates());
        return "realestate/notapproved";
    }
}