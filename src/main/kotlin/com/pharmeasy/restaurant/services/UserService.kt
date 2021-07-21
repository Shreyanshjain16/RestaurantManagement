package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository){



    public fun getUsers() : List<User>{
     return userRepository.findAll()
    }

    fun addUser(user: User) : User{
        return userRepository.save(user)
    }
}