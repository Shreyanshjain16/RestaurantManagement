package com.pharmeasy.restaurant.model

import com.pharmeasy.restaurant.type.UserType
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    var userId:Long?,
    @Enumerated(EnumType.STRING)
    var userType : UserType,
    var username:String,
    //var age:Long

    //var age:
    //time created at , uodated at
    //list of custo. within a range // custom query
    //time sortation
    // Admin -1
    //Customer -2


)
