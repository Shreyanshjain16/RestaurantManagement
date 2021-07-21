package com.pharmeasy.restaurant.model

import javax.persistence.*


@Entity
@Table(name="items")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var itemid: Long?,
    var itemname: String,
    var itemquantity:Long
)