package com.pharmeasy.restaurant.model

import com.pharmeasy.restaurant.type.UserStatus
import com.pharmeasy.restaurant.type.UserType
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long?,
    @Enumerated(EnumType.STRING)
    var userType: UserType,
    var username: String,
    var age: Long,
    @Enumerated(EnumType.STRING)
    var userStatus: UserStatus = UserStatus.ACTIVE
//    @CreationTimestamp
//    var createdAt : Timestamp,
//    @UpdateTimestamp
//    var updatedAt : Timestamp,


    //Sortation


)
