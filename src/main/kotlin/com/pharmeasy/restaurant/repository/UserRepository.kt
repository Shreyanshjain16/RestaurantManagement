package com.pharmeasy.restaurant.repository

import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.type.UserStatus
import com.pharmeasy.restaurant.type.UserType
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User,Long>{
    fun getAllByUserType(userType: UserType, pageRequest: PageRequest) : List <User>
    @Modifying
    @Query("update User  u set u.userStatus=:userStatus where u.userId=:userId ")
    fun updateUserStatus(userId : Long, userStatus: UserStatus)


    // How to perform custom filtering . eg : getting users within a given age range





}


// Indexing
