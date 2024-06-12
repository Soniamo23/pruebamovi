package com.example.prueba.service

import com.example.prueba.entity.Character

import com.example.prueba.repository.CharacterRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CharacterService {
    @Autowired
    private lateinit var characterRepository: CharacterRepository
    fun list (): List<Character>{
        return characterRepository.findAll()
    }
    fun getById(id: Long) : Character{
        return characterRepository.findById(id).orElseThrow{ RuntimeException("character not found!") }
    }
    fun save (character: Character):Character{
        return characterRepository.save(character)
    }
    fun update(id: Long, character: Character):Character{
        val existingCharacter = characterRepository.findById(id).orElseThrow { RuntimeException("character not found") }
        existingCharacter.id = character.id
        existingCharacter.description = character.description
        existingCharacter.cost = character.cost
        existingCharacter.stock = character.stock
        existingCharacter.scene = character.scene
        return characterRepository.save(existingCharacter)
    }
    fun delete(id:Long){
        if (characterRepository.existsById(id)){
            characterRepository.deleteById(id)
        }else{
            throw RuntimeException("character not found")
        }
    }
}
