package com.shop.fuelcoupons.web;

import com.shop.fuelcoupons.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class LoginController {

    private final FuelService fuelService;

    @Autowired
    public LoginController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(Model model) {
        model.addAttribute("fuelStations", fuelService.getAllWithFuelStations());
        return "login";
    }
}
