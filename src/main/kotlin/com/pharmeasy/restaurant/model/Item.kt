package com.pharmeasy.restaurant.model

import javax.persistence.*


@Entity
@Table(name="items")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var itemId: Long?,
    var itemName: String,
    var itemquantity:Long

)