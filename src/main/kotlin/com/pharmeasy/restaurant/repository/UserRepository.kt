package com.pharmeasy.restaurant.repository

import com.pharmeasy.restaurant.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long>