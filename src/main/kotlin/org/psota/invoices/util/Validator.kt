package org.psota.invoices.util

import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException
import javax.validation.Validation
import javax.validation.ValidatorFactory

object Validator {
    private val validatorFactory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
    private val validator = validatorFactory.validator

    fun <T> validate(dto: T) {
        val violations: Set<ConstraintViolation<T>> = validator.validate(dto)
        if (violations.isNotEmpty()) {
            val violationMessages = violations.joinToString(", ") { "${it.propertyPath} ${it.message}" }
            throw ConstraintViolationException(violationMessages, violations)
        }
    }
}