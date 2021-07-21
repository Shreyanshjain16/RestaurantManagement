package com.pharmeasy.restaurant.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    var userId:Long?,
    var usertype:Long,
    var username:String
)
