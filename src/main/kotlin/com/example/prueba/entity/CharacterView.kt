package com.example.prueba.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name= "character")
class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    var description: String? = null
    var cost: Double? = null
    var stock: Int? = null

    @ManyToOne
    @JoinColumn(name = "scene_id", nullable = false)
    var scene: Scene? = null
}