package dev.gutierrez.services.login;

import dev.gutierrez.daos.appuser.AppUserDAO;
import dev.gutierrez.entities.Entities.AppUser;
import dev.gutierrez.exceptions.NoUserFoundException;
import dev.gutierrez.exceptions.PasswordException;

public class LoginServiceImpl implements LoginService{
    private AppUserDAO appUserDAO;
    public LoginServiceImpl(AppUserDAO appUserDAO){
        this.appUserDAO = appUserDAO;
    }
    @Override
    public AppUser validateUser(String username, String password) {
        AppUser appUser = this.appUserDAO.getUserByUserName(username);
        if(appUser == null){
            throw new NoUserFoundException("No employee found with username");
        }
        if(!appUser.getPassword().equals(password)){
            throw new PasswordException("password does not match");
        }
        return appUser;
    }
}
