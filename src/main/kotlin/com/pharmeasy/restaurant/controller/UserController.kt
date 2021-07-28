package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.services.UserService
import com.pharmeasy.restaurant.type.UserStatus
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController

class UserController(private val userService: UserService) {

    companion object {
        private val log = LoggerFactory.getLogger(UserController::class.java)
    }

    //Pagination
    //get the Users



    @GetMapping("/users")
    public fun getUsers(@RequestParam(defaultValue = "0") page: Int,@RequestParam(defaultValue = "5") size : Int): Page<User> {
        log.info("All User details received")
        return userService.getUsers(page,size)
    }

    //add users
    // Kafka for event production and consumption
    @PostMapping("/users")
    fun addUsers(@RequestBody listOfUsers: List<User>): List<User> {
        log.info("Users Added")
        return userService.addUsers(listOfUsers)
    }

    //Get User by id
    @GetMapping("/users/{userId}")
    public fun getUser(@PathVariable userId: Long): ResponseEntity<Any> {
        log.info("details of $userId received")
        val user = userService.getUser(userId)
        if(user==null)
        return ResponseEntity.notFound().build()
        else
            return ResponseEntity.ok(user)
    }

    //update user
    @PutMapping("/users/{userId}")
    fun updateUser(@PathVariable userId: Long, @RequestBody user: User): User {
        log.info("details of $userId updated")
        return userService.updateUser(userId, user)
    }

// SoftDelete Active/Inactive
    @PutMapping("users/{userId}/status")
    fun updateUserStatus(@PathVariable userId: Long,@RequestParam status : UserStatus){
        userService.updateUserStatus(userId,status)
    }

//    @GetMapping("users/{userId}/orders")
//    fun getMyOrders(@PathVariable userId: Long){
//
//    }


}