package com.robson.back_end.config.security;

import com.robson.back_end.model.Client;
import com.robson.back_end.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AuthenticatorService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> clientOptional = clientRepository.findByLogin(username);
        if(clientOptional.isPresent()) {
            return clientOptional.get();
        }
        else {
            throw  new UsernameNotFoundException("Usuário não encontrado!");
        }
    }
}
