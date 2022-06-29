package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.UserRepository;
import org.launchcode.codingevents.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    //key used to store user ID's
    private static final String userSessionKey = "user";

    //looks for data with the key user in the user's session.
    //if it finds one, it attempts to retrieve corresponding User object from database
    //if no user is in the session, or there was no user with given ID, null is returned
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    //uses and HttpSession object to store key/value pair
    private static void setUserSessionKey(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }
    //The HttpSession class handles the details of session creation and lookup for us,
    // including generating unique session IDs and session cookies.
}
