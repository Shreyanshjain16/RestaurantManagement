package com.pharmeasy.restaurant.repository

import com.pharmeasy.restaurant.model.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem,Long> {
}