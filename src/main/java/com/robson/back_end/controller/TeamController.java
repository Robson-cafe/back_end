package com.robson.back_end.controller;

import com.robson.back_end.dto.TeamRequesDTO;
import com.robson.back_end.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    TeamService teamService;
    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody TeamRequesDTO teamRequestDTO) {
        return teamService.save(teamRequestDTO);
    }

}
