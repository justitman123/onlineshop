package com.shop.fuelcoupons.web.order;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class OrderController extends AbstractOrderController {

    @GetMapping(value = "order", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createOrder(Model model) {
        return "orderForm";
    }
}