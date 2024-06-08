package com.example.springboot_3kotlin

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GreetingService(private val greetingRepository: GreetingRepository) {
    fun saveGreeting(greeting: Greeting): Greeting = greetingRepository.save(greeting)
    fun getGreetingById(id: Long): Greeting? = greetingRepository.findByIdOrNull(id)
    fun deleteGreetingById(id: Long) = greetingRepository.deleteById(id)
}