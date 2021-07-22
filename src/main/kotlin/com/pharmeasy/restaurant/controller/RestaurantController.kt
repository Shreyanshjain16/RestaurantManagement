package com.pharmeasy.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController

@RestController
public class RestaurantController {


    @GetMapping("/")
    public fun home(): String{
        return "Welcome to Restaurant"
    }

}
