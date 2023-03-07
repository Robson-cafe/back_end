package com.robson.back_end.service;

import com.robson.back_end.dto.BoxRequestDTO;
import com.robson.back_end.dto.BoxResponseDTO;
import com.robson.back_end.model.Box;
import com.robson.back_end.repository.BoxRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService {
    @Autowired
    BoxRepository boxRepository;

    public List<BoxResponseDTO> findAll(String name, int min, int max) {
        return boxRepository.findAllByNameContainingIgnoreCaseAndCapacityGreaterThanEqualAndCapacityLessThanEqual(name, min, max).stream().map(BoxResponseDTO::new).toList();
    }

    public BoxRequestDTO save(BoxRequestDTO boxRequestDTO) {
        Box box = new Box();
        box.setName(boxRequestDTO.getName());
        box.setCapacity(boxRequestDTO.getCapacity());
        box.setCreate_by("Admin");
        boxRepository.save(box);
        return boxRequestDTO;
    }
}
