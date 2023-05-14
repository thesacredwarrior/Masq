package com.warriorsacred.masq.util

import android.util.Patterns

fun validateEmail(email: String): RegisterValidation {
    if (email.isEmpty())
        return RegisterValidation.Failed("Email cant be empty")
    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return RegisterValidation.Failed("Wrong email format")

    return RegisterValidation.Success
}


fun validatePassword(password: String): RegisterValidation {
    if (password.isEmpty())
        return RegisterValidation.Failed("Password cannot be empty")

    if (password.length < 6)
        return RegisterValidation.Failed("Password should be at least 6 characters long")

    val pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$".toRegex()
    if (!password.matches(pattern))
        return RegisterValidation.Failed("Password should contain at least one uppercase letter, one lowercase letter, and one digit, and no whitespace")

    return RegisterValidation.Success
}

