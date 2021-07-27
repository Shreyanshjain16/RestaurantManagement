package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.controller.UserController
import com.pharmeasy.restaurant.exception.RequestException
import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.repository.UserRepository
import com.pharmeasy.restaurant.type.UserType

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    companion object {private val log = LoggerFactory.getLogger(UserController::class.java)}

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

    fun authorize(userId: Long,rolesRequired : List<UserType>) {
            var user  = getUser(userId)
        if(user.userType !in rolesRequired)
            throw RequestException("The User : $userId Is not authorized to do this task")


    }


}