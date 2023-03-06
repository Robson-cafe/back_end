package com.robson.back_end.controller;

import com.robson.back_end.dto.ClientResponsyDTO;
import com.robson.back_end.model.Client;
import com.robson.back_end.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public List<ClientResponsyDTO> findAll() {
        List<Client> list = clientRepository.findAll();
        return list.stream().map(ClientResponsyDTO::new).toList();
    }
    @PostMapping
    public Client Sava(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
