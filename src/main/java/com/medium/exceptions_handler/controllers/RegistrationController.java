package com.medium.exceptions_handler.controllers;

import com.medium.exceptions_handler.enums.InternalErrorCode;
import com.medium.exceptions_handler.exceptions.ForbiddenOperationException;
import com.medium.exceptions_handler.exceptions.MissingFieldException;
import com.medium.exceptions_handler.pojos.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sign-up")
public class RegistrationController {

    private static List<User> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity<User> signUp(@RequestBody User user) {

        if (user.getFirstName() == null || user.getFirstName().isEmpty())
            throw new MissingFieldException("First name missing", InternalErrorCode.FIRST_NAME_MISSING);

        if (user.getLastName() == null || user.getLastName().isEmpty())
            throw new MissingFieldException("Last name missing", InternalErrorCode.LAST_NAME_MISSING);

        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty())
            throw new MissingFieldException("First name missing", InternalErrorCode.EMAIL_ADDRESS_MISSING);

        if (RegistrationController.users.contains(user))
            throw new ForbiddenOperationException("User already exists", InternalErrorCode.USER_ALREADY_EXISTS);

        users.add(user);
        return ResponseEntity.ok(user);

    }

}
