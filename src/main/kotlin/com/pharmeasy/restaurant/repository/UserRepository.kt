package com.pharmeasy.restaurant.repository

import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.type.UserType
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long>{
    fun getAllByUserType(userType: UserType) : List <User>


}


// Indexing
