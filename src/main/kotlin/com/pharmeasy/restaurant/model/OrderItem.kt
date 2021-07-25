package com.pharmeasy.restaurant.model

import javax.persistence.*


@Entity
@Table(name="order_items")
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?,
    var orderId :Long,
    var itemId:Long,
    var itemQuantity:Long
    )
