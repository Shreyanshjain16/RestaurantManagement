package com.pharmeasy.restaurant.model

import javax.persistence.*


@Entity
@Table(name="items")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var itemId: Long?,
    var itemname: String,
    var itemquantity:Long
    //validations in controller
    //Exceoptin
)