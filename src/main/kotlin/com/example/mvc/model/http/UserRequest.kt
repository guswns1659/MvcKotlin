package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty

data class UserRequest (

        var name: String?=null,
        var phoneNumber: String?=null
)

