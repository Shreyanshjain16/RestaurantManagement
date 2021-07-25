package com.pharmeasy.restaurant.model

import com.pharmeasy.restaurant.type.OrderStatus
import javax.persistence.*

@Entity
@Table(name="orders")
data class Order (
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var orderId : Long?,
    var userId  : Long,
    @Enumerated(EnumType.STRING)
    var orderStatus : OrderStatus
    )


