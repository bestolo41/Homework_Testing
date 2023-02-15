package com.example.homework_testing.model;

import com.example.homework_testing.exception.IncorrectValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.homework_testing.model.User.*;
import static com.example.homework_testing.model.UserTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void shouldAcceptOfData() {
        User out = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        assertEquals(CORRECT_LOGIN, out.getLogin());
        assertEquals(CORRECT_EMAIL, out.getEmail());
    }

    @Test
    public void shouldThrowExceptionIfDataIsEmptyOrNull() {
        assertThrows(IncorrectValueException.class, () -> new User());
    }

    @Test
    public void shouldReturnTrueIfEmailIsIncorrect() {
        assertTrue(isIncorrectEmail(EMAIL_WITHOUT_DOT));
        assertTrue(isIncorrectEmail(EMAIL_WITHOUT_AT));
        assertTrue(isIncorrectEmail(EMAIL_WITHOUT_ALL));
        assertFalse(isIncorrectEmail(CORRECT_EMAIL));
    }

    @Test
    public void shouldReturnTrueIfLoginEqualsEmail() {
        assertTrue(isEqualsLoginAndEmail(LOGIN_EQUALS_EMAIL, EMAIL_EQUALS_LOGIN));
        assertFalse(isEqualsLoginAndEmail(CORRECT_LOGIN, CORRECT_EMAIL));
    }

}