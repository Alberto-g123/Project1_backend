package dev.gutierrez.services.login;

import dev.gutierrez.entities.Entities.AppUser;

public interface LoginService {

    AppUser validateUser(String username, String password);
}
