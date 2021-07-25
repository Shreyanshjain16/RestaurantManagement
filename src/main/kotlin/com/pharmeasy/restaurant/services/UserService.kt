package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addUsers(listOfUsers: List<User>): List<User> {
        return userRepository.saveAll(listOfUsers)
    }

    fun getUser(userId: Long): User {
        return userRepository.getById(userId)
    }

    fun updateUser(userId: Long, user: User): User {
        user.userId = userId
        return userRepository.save(user)
    }

    fun deleteUser(userId: Long) {
        return userRepository.deleteById(userId)
    }


}