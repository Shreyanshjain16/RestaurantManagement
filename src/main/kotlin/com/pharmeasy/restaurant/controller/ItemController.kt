package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.exception.ErrorResponse
import com.pharmeasy.restaurant.model.Item
import com.pharmeasy.restaurant.services.ItemService
import com.pharmeasy.restaurant.services.UserService
import com.pharmeasy.restaurant.type.UserType
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ItemController(private val itemService: ItemService, private val userService: UserService) {
    companion object {private val log = LoggerFactory.getLogger(UserController::class.java)}

    @GetMapping("/items")
    fun getItems() : List<Item>{
        return itemService.getItems()
    }


    @PostMapping("/items")
    fun addItems(@RequestBody listOfItems : List<Item>,@RequestHeader userId:Long): ResponseEntity<Any>{
        try{
            userService.authorize(userId, listOf(UserType.ADMIN))
            return ResponseEntity(itemService.addItems(listOfItems),HttpStatus.OK)
        }catch(e:Exception){
            return ResponseEntity(ErrorResponse(e.message!!,"Post API request for adding orders failed"),HttpStatus.BAD_REQUEST)
        }

    }


    //Get Item by id
    @GetMapping("/items/{itemId}")
    public fun getItem(@PathVariable itemId : Long): Item {

        return itemService.getItem(itemId)
    }

    //update Item
    @PutMapping("/items/{itemId}")
    fun updateItem(@PathVariable itemId:Long, @RequestBody item: Item, @RequestHeader userId: Long): ResponseEntity<Any>{
        try {
            userService.authorize(userId, listOf(UserType.ADMIN))
            return ResponseEntity(itemService.updateItem(itemId, item),HttpStatus.OK)
        }catch(e:Exception){
            return ResponseEntity(ErrorResponse(e.message!!,"Put API request for updating items failed"),HttpStatus.BAD_REQUEST)
        }
    }

}