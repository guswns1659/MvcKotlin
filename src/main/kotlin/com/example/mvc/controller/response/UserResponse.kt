package com.example.mvc.controller.response

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class UserResponse(

    @field:NotEmpty
    @field:Pattern(regexp = "")
    private var result: Result?=null,
    private var description: String?=null

)



