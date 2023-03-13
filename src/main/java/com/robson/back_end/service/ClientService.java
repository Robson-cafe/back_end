package com.robson.back_end.service;

import com.robson.back_end.dto.ClientRequestDTO;
import com.robson.back_end.dto.ClientResponsyDTO;
import com.robson.back_end.model.Client;
import com.robson.back_end.repository.ClientRepository;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public List<Client> findAll(String name) {
        if(name.equals("")) {
            return clientRepository.findAll();
        }
        else {
            return clientRepository.findAllByNameIgnoreCase(name);
        }
    }

    @Transactional
    public ClientResponsyDTO save(ClientRequestDTO clientRequestDTO) {
        Client client = clientRequestDTO.toClient();
        return new ClientResponsyDTO(clientRepository.save(client));
    }

    public ResponseEntity<Object> find(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ClientResponsyDTO(clientOptional.get()));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<Object> upDate(Long id, ClientRequestDTO clientRequestDTO) {
        // achar
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()) {
            //modificar
            Client client = clientOptional.get();
            //BeanUtils.copyProperties(clientRequestDTO, client);
            if(clientRequestDTO.getName() != null) {
                client.setName(clientRequestDTO.getName());
            }

            if(clientRequestDTO.getLogin() != null) {
                client.setLogin(clientRequestDTO.getLogin());
            }

            if(clientRequestDTO.getPassword() != null) {
                client.setPassword(clientRequestDTO.getPassword());
            }
            //salvar
            ClientResponsyDTO clientResponsyDTO = new ClientResponsyDTO(clientRepository.save(client));
            return ResponseEntity.status(HttpStatus.CREATED).body(clientResponsyDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }

    }
    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()) {
            Client client = clientOptional.get();

            clientRepository.delete(client);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
    }
}
