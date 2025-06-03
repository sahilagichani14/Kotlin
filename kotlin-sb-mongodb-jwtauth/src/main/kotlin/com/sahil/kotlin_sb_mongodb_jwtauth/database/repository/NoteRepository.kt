package com.sahil.kotlin_sb_mongodb_jwtauth.database.repository

import com.sahil.kotlin_sb_mongodb_jwtauth.database.model.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository: MongoRepository<Note, ObjectId> {
    fun findByOwnerId(ownerId: ObjectId): List<Note>
}