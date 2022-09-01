package com.geekbrains.myfirsttests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_CyrillicSymbols_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("приветмир@mail.ru"))
    }

    @Test
    fun emailValidator_OverflowMaxLengthBeforeEta_ReturnsFalse() {
        val longEmail = "1234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890@yandex.ru"

        assertFalse(EmailValidator.isValidEmail(longEmail))
    }

    @Test
    fun emailValidator_OverflowMaxLengthAfterEta_ReturnsFalse() {
        val longEmail = "dmitrj1992@0000000000111111111122222222223333333333444444444455555555556666666666"

        assertFalse(EmailValidator.isValidEmail(longEmail))
    }

    @Test
    fun emailValidator_OverflowMaxLengthAfterDot_ReturnsFalse() {
        val longEmail = "dmitrj1992@mail.000000000011111111112222222222"

        assertFalse(EmailValidator.isValidEmail(longEmail))
    }

    @Test
    fun emailValidator_NotContainsEta_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("приветмир-mail.ru"))
    }

    @Test
    fun emailValidator_NotValidSymbols_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("приветмир@mail?.ru"))
    }
}
