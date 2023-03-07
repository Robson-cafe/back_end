package com.robson.back_end.controller;

//import com.robson.back_end.dto.BoxDTO;
import com.robson.back_end.model.Box;
import com.robson.back_end.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boxes")
public class BoxController
{
    @Autowired
    BoxRepository boxRepository;

    @GetMapping
    public List<Box> findAll() {
        return boxRepository.findAll();
    }
}
