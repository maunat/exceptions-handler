package com.medium.exceptions_handler.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String firstName, lastName, emailAddress;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) return false;

        User user = (User) obj;
        return this.emailAddress.equalsIgnoreCase(user.getEmailAddress());
    }
}
