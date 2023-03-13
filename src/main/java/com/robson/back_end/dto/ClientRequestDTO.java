package com.robson.back_end.dto;

import com.robson.back_end.model.Client;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ClientRequestDTO {
    String name;
    String login;
    String password;
    String confirm_password;

    public ClientRequestDTO()
    {
    }

    public ClientRequestDTO(
        String name,
        String login,
        String password,
        String confirm_password
    )
    {
        this.name = name;
        this.login = login;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public ClientRequestDTO(
        String name,
        String login,
        String password
    )
    {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public Client toClient() {
        password = new BCryptPasswordEncoder().encode(password);

        Client client = new Client();
        client.setName(name);
        client.setLogin(login);
        client.setPassword(password);
        return client;
    }
}
