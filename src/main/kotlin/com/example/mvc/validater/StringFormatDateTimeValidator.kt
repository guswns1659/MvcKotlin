package com.example.mvc.validater

import com.example.mvc.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StringFormatDateTimeValidator : ConstraintValidator<StringFormatDateTime, String> {

    private var pattern : String? = null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        this.pattern = constraintAnnotation?.pattern
    }

    // 정상이면 true, 비정상이면 false
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        try {
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
            return true

        } catch (e:Exception) {
            return false
        }
    }
}
