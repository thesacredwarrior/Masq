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
        return RegisterValidation.Failed("Пароль не может быть пустым")

    if (password.length < 6)
        return RegisterValidation.Failed("Пароль должен быть не менее 6 символов")

    val pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$".toRegex()
    if (!password.matches(pattern))
        return RegisterValidation.Failed("Пароль должен содержать как минимум одну заглавную букву, одну строчную букву и одну цифру и не содержать пробелов.")

    return RegisterValidation.Success
}

