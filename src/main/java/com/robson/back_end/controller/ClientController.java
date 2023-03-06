package com.robson.back_end.controller;

import com.robson.back_end.dto.ClientRequestDTO;
import com.robson.back_end.dto.ClientResponsyDTO;
import com.robson.back_end.model.Client;
//import com.robson.back_end.repository.ClientRepository;
import com.robson.back_end.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public List<ClientResponsyDTO> findAll() {
        List<Client> list = clientService.findAll();
        return list.stream().map(ClientResponsyDTO::new).toList();
    }
    @PostMapping
    public ClientResponsyDTO save(@RequestBody ClientRequestDTO clientRequestDTO) {
        return clientService.save(clientRequestDTO);
    }
}
