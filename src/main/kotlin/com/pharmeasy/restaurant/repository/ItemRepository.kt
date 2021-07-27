package com.pharmeasy.restaurant.repository

import com.pharmeasy.restaurant.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ItemRepository : JpaRepository<Item,Long>{

}