package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.model.Item
import com.pharmeasy.restaurant.repository.ItemRepository
import org.springframework.stereotype.Service


@Service
class ItemService(private val itemRepository: ItemRepository) {


    fun getItems(): List<Item> {
        return itemRepository.findAll()
    }

    fun addItems(listOfItems: List<Item>): List<Item> {
        //validate
        return itemRepository.saveAll(listOfItems)
    }

    fun getItem(itemId: Long): Item {

        return itemRepository.getById(itemId)
    }

    fun updateItem(itemId: Long, item: Item): Item {
        item.itemId = itemId
        return itemRepository.save(item)
    }


}