package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.model.Item
import com.pharmeasy.restaurant.services.ItemService
import org.springframework.web.bind.annotation.*

@RestController
class ItemController(private val itemService: ItemService) {

    @GetMapping("/items")
    fun getItems() : List<Item>{
        return itemService.getItems()
    }

    @PostMapping("/items")
    fun addItem(@RequestBody item : Item): Item {
        return itemService.addItem(item)
    }


    //Get Item by id
    @GetMapping("/items/{itemId}")
    public fun getItem(@PathVariable itemId : Long): Item {
        return itemService.getItem(itemId)
    }

    //update Item
    @PutMapping("/items/{itemId}")
    fun updateItem(@PathVariable itemId:Long, @RequestBody item: Item): Item {
        return itemService.updateItem(itemId,item)
    }

}