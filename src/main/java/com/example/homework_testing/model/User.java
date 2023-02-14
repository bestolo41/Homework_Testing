package com.example.homework_testing.model;

import com.example.homework_testing.exception.IncorrectValueException;
import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private String login;
    private String email;

    public User() {
        new User(null, null);
    }

    public User(String login, String email) {
        setLogin(login);
        setEmail(email);
    }

    public void setLogin(String login) {
        if (login == null || login.isEmpty() || login.isBlank()) {
            throw new IncorrectValueException("The login cannot be empty");
        } else if (isEqualsLoginAndEmail(login, email)) {
            throw new IncorrectValueException("The login cannot match the email");
        } else {
            this.login = login;
        }
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || email.isBlank()) {
            throw new IncorrectValueException("The email cannot be empty");
        } else if (isEqualsLoginAndEmail(login, email)) {
            throw new IncorrectValueException("The login cannot match the email");
        } else if (isIncorrectEmail(email)) {
            throw new IncorrectValueException("Incorrect email");
        } else {
            this.email = email;
        }
    }

    public static boolean isEqualsLoginAndEmail(String login, String email) {
        return login.equals(email);
    }

    public static boolean isIncorrectEmail(String email) {
        return !email.contains("@") || !email.contains(".");
    }

}
