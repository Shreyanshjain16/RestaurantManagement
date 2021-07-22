package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.model.Item
import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.services.ItemService
import com.pharmeasy.restaurant.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userService:UserService) {




    //get the Users
    @GetMapping("/users")
    public fun getUsers() : List<User> {
        return userService.getUsers()
    }

    //add user
    @PostMapping("/users")
     fun addUser(@RequestBody user: User):User{
        return userService.addUser(user)
    }

    //Get User by id
    @GetMapping("/users/{userId}")
    public fun getUser(@PathVariable userId : Long):User{
        return userService.getUser(userId)
    }

    //update user
    @PutMapping("/users/{userId}")
    fun updateUser(@PathVariable userId:Long,@RequestBody user: User):User{
        return userService.updateUser(userId,user)
    }

//    @DeleteMapping("users/{userId}")
//    fun deleteUser(@PathVariable userId: Long){
//        userService.deleteUser(userId)
//    }



}