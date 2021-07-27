package com.pharmeasy.restaurant.controller;

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController

@RestController
public class RestaurantController {
    companion object {private val log = LoggerFactory.getLogger(UserController::class.java)}


    @GetMapping("/")
    public fun home(): String{
        return "Welcome to Restaurant"
    }

}
