package com.example.mvc.model.http

import com.example.mvc.annotation.StringFormatDateTime
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue

data class UserRequest(

    var name: String? = null,
    var phoneNumber: String? = null,

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt: String? = null // yyyy-MM-dd HH:mm:ss
)


