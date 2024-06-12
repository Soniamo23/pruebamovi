package com.example.prueba.controller

import com.example.prueba.entity.Character
import com.example.prueba.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/characters")
class CharacterController {
    @Autowired
    lateinit var characterService: CharacterService

    @GetMapping
    fun list(): List<Character> {
        return  characterService.list()

    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long): Character {
        return characterService.getById(id)
    }
    @PostMapping
    fun save(@RequestBody character: Character):Character{
        return characterService.save(character)
    }
    @PutMapping("/{id}")
    fun updateCharacter(@PathVariable id: Long, @RequestBody character: Character): Character {
        return characterService.update(id, character)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):String {
        characterService.delete(id)
        return "character $id deleted"
    }
}