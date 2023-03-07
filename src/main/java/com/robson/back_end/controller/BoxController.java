package com.robson.back_end.controller;

import com.robson.back_end.dto.BoxRequestDTO;
import com.robson.back_end.dto.BoxResponseDTO;
import com.robson.back_end.model.Box;
import com.robson.back_end.service.BoxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boxes")
public class BoxController
{
    @Autowired
    BoxService boxService;

    @GetMapping
    public List<BoxResponseDTO> findAll(
        @RequestParam(name = "name", defaultValue = "") String name,
        @RequestParam(name = "min", defaultValue = "0") int min,
        @RequestParam(name = "max", defaultValue = "9999") int max
    )
    {
        return boxService.findAll(name, min, max);
    }

    @PostMapping
    public BoxRequestDTO save(@RequestBody BoxRequestDTO boxRequestDTO) {
        return boxService.save(boxRequestDTO);
    }
}
