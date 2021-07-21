package com.pharmeasy.restaurant.repository

import com.pharmeasy.restaurant.model.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item,Long>{
}