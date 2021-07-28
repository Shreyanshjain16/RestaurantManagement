package com.pharmeasy.restaurant.model

import com.pharmeasy.restaurant.type.UserStatus
import com.pharmeasy.restaurant.type.UserType
import com.sun.xml.bind.v2.TODO
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
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
    var age : Long,
    @Enumerated(EnumType.STRING)
    var userStatus: UserStatus = UserStatus.ACTIVE
//    @CreationTimestamp
//    var createdAt : Timestamp,
//    @UpdateTimestamp
//    var updatedAt : Timestamp,



    //Sortation




)
