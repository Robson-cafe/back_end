package com.robson.back_end.service;

import com.robson.back_end.dto.ClientRequestDTO;
import com.robson.back_end.dto.ClientResponsyDTO;
import com.robson.back_end.model.Client;
import com.robson.back_end.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public ClientResponsyDTO save(ClientRequestDTO clientRequestDTO) {
        Client client = clientRequestDTO.toClient();
        return new ClientResponsyDTO(clientRepository.save(client));
    }
}
