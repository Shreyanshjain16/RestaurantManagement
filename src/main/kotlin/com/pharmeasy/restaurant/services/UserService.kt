package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.controller.UserController
import com.pharmeasy.restaurant.exception.RequestException
import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.repository.UserRepository
import com.pharmeasy.restaurant.type.UserStatus
import com.pharmeasy.restaurant.type.UserType

import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {
    companion object {private val log = LoggerFactory.getLogger(UserController::class.java)}

    fun getUsers(): List<User> {
        log.info("UserService.getUsers()")

        return userRepository.findAll()
    }

    fun addUsers(listOfUsers: List<User>): List<User> {
        log.info("UserService.addUsers , received $listOfUsers ")
        return userRepository.saveAll(listOfUsers)
    }

    fun getUser(userId: Long): User? {

        return userRepository.findByIdOrNull(userId)
    }

    fun updateUser(userId: Long, user: User): User {
        user.userId = userId
        return userRepository.save(user)
    }

    fun deleteUser(userId: Long) {
        return userRepository.deleteById(userId)
    }

    fun authorize(userId: Long,rolesRequired : List<UserType>) {
        var user = getUser(userId)?:throw RequestException("The User : $userId does not exist")
        if (user.userType !in rolesRequired)
            throw RequestException("The User : $userId Is not authorized to do this task")
    }
    @Transactional
    fun updateUserStatus(userId: Long, status: UserStatus) {
        userRepository.updateUserStatus(userId,status)
    }


}