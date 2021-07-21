package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.model.Item
import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.repository.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping


@Service
class ItemService (private val itemRepository: ItemRepository){


    fun getItems() : List <Item>{
        return itemRepository.findAll()
    }

    fun addItem(item: Item) : Item {
        return itemRepository.save(item)
    }

    fun getItem(itemId :Long ) : Item{

        return itemRepository.getById(itemId)
    }

    fun updateItem(itemId: Long, item: Item): Item {
        item.itemId=itemId
        return itemRepository.save(item)
    }





}