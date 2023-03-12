package com.robson.back_end.service;

import com.robson.back_end.dto.BoxRequestDTO;
import com.robson.back_end.dto.BoxResponseDTO;
import com.robson.back_end.dto.ClientResponsyDTO;
import com.robson.back_end.model.Box;
import com.robson.back_end.model.Client;
import com.robson.back_end.repository.BoxRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {
    @Autowired
    BoxRepository boxRepository;

    public List<BoxResponseDTO> findAll(String name, int min, int max) {
        return boxRepository.findAllByNameContainingIgnoreCaseAndCapacityGreaterThanEqualAndCapacityLessThanEqual(name, min, max).stream().map(BoxResponseDTO::new).toList();
    }

    @Transactional
    public BoxRequestDTO save(BoxRequestDTO boxRequestDTO) {
        Box box = new Box();
        box.setName(boxRequestDTO.getName());
        box.setCapacity(boxRequestDTO.getCapacity());
        box.setCreate_by("Admin");
        boxRepository.save(box);
        return boxRequestDTO;
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Box> boxOptional = boxRepository.findById(id);
        if(boxOptional.isPresent()) {
            return ResponseEntity.ok().body(new BoxResponseDTO(boxOptional.get()));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<Object> upDate(Long id, BoxRequestDTO boxRequestDTO) {
        // achar
        Optional<Box> boxOptional = boxRepository.findById(id);
        if(boxOptional.isPresent()) {
            //modificar
            Box box = boxOptional.get();
            //BeanUtils.copyProperties(clientRequestDTO, client);
            if(boxRequestDTO.getName() != null) {
                box.setName(boxRequestDTO.getName());
            }

            if(boxRequestDTO.getCapacity() != 0) {
                box.setCapacity(boxRequestDTO.getCapacity());
            }

            //salvar
            BoxResponseDTO boxResponsyDTO = new BoxResponseDTO(boxRepository.save(box));
            return ResponseEntity.status(HttpStatus.OK).body(boxResponsyDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Optional<Box> boxOptional = boxRepository.findById(id);
        if(boxOptional.isPresent()) {
            Box box = boxOptional.get();

            boxRepository.delete(box);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado.");
        }
    }
}
