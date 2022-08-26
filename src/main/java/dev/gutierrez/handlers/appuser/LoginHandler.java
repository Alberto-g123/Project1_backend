package dev.gutierrez.handlers.appuser;

import com.google.gson.Gson;
import dev.gutierrez.app.App;
import dev.gutierrez.dtos.LoginCredentials;
import dev.gutierrez.entities.Entities.AppUser;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class LoginHandler implements Handler {


    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String body = ctx.body();
        Gson gson = new Gson();
        LoginCredentials credentials = gson.fromJson(body, LoginCredentials.class);

        AppUser appUser = App.loginService.validateUser(credentials.getUsername(), credentials.getPassword());
        String json = gson.toJson(appUser);
        ctx.result(json);


    }
}
