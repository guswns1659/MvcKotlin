package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue

data class UserRequest (

        var name: String?=null,
        var phoneNumber: String?=null,

        var createdAt:String?=null // yyyy-MM-dd HH:mm:ss
) {
    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss")
    private fun isValidCreatedAt():Boolean {

        try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            return true

        } catch (e:Exception) {
            return false
        }
    }
}

