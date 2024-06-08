package com.example.springboot_3kotlin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Controller
@ResponseBody
@RequestMapping("/greeting")
class GreetingController(private val greetingService: GreetingService) {
    @RequestMapping(method = [RequestMethod.POST, RequestMethod.PUT])
    fun writeGreeting(@RequestBody greeting: Greeting): Greeting = greetingService.saveGreeting(greeting)

    @GetMapping("/{id}")
    fun getGreetingById(@PathVariable id: Long): Greeting =
        greetingService.getGreetingById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No greeting found for $id")

    @DeleteMapping("/{id}")
    fun deleteGreetingById(@PathVariable id: Long) = greetingService.deleteGreetingById(id)
}