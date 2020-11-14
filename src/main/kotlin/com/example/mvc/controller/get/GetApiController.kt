package com.example.mvc.controller.get

import org.springframework.web.bind.annotation.*

@RestController // Rest API Controller 동작
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"])
    fun hello(): String{
        return "hello kotlin"
    }

    // http 제약없이 사용
    @RequestMapping(method = [RequestMethod.GET], path =  ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age:Int): String {
        println("$name, $age")
        return "$name $age"
    }
}