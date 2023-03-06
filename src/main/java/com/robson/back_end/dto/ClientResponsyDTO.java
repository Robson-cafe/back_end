package com.robson.back_end.dto;

import com.robson.back_end.model.Client;

public class ClientResponsyDTO {
    String name;
    String login;

    public ClientResponsyDTO(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public ClientResponsyDTO(Client client) {
        this.name = client.getName();
        this.login = client.getLogin();
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
}
