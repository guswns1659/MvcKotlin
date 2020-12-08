package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.apache.catalina.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController // Rest API Controller 동작
class GetApiController {

    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {
        return age?.let {

            // age not null
            if (it < 20) {
                return ResponseEntity.status(400).body("age 값은 20보다 커야 합니다.")
            }
            ResponseEntity.ok("OK")
        }?: kotlin.run {

            // age is null
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

    }

}
