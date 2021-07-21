package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController(private val userService:UserService) {



    @GetMapping("/")
    public fun home(): String{
        return "Welcome to Restaurant"
    }

    //get the Users
    @GetMapping("/users")
    public fun getUsers() : List<User> {
        return userService.getUsers()



    }

    @PostMapping("/users")
    public fun addUser(@RequestBody user: User):User{
        return userService.addUser(user)
    }
}