package com.asimkilic.account.dto

import java.math.BigDecimal
import javax.validation.constraints.*
data class CreateAccountRequest(

        @field:NotBlank
        val customerId: String,
        @field:Min(0)
        val initialCredit: BigDecimal
)