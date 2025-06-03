package com.sahil.kotlin_sb_mongodb_jwtauth.database.repository

import com.sahil.kotlin_sb_mongodb_jwtauth.database.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, ObjectId> {
    fun findByEmail(email: String): User?
}