package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.model.Item
import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.services.ItemService
import com.pharmeasy.restaurant.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
class MyController(private val userService:UserService, private val itemService: ItemService) {



    @GetMapping("/")
    public fun home(): String{
        return "Welcome to Restaurant"
    }

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


    @GetMapping("/items")
    fun getItems() : List<Item>{
        return itemService.getItems()
    }

    @PostMapping("/items")
    fun addItem(@RequestBody item : Item):Item{
        return itemService.addItem(item)
    }

    //Get Item by id
    @GetMapping("/items/{itemId}")
    public fun getItem(@PathVariable itemId : Long):Item{
        return itemService.getItem(itemId)
    }

    //update Item
    @PutMapping("/items/{itemId}")
    fun updateItem(@PathVariable itemId:Long,@RequestBody item: Item):Item{
        return itemService.updateItem(itemId,item)
    }



}