package com.pharmeasy.restaurant.repository

import com.pharmeasy.restaurant.model.Order
import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.type.OrderStatus
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order,Long >{
    fun getAllByOrderStatus(orderStatus: OrderStatus) : List <Order>

}