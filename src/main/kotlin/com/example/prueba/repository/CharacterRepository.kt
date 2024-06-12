package com.example.prueba.repository

import com.example.prueba.entity.Character
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository: JpaRepository<Character, Long?> {
}