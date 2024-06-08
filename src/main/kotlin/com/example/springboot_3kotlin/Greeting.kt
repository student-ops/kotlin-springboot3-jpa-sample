package com.example.springboot_3kotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Greeting(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOMATIC生成戦略を指定
    val id: Long? = null,
    val languageKey: String,
    val greeting: String
)