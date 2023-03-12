package com.robson.back_end.service;

import com.robson.back_end.dto.TeamRequesDTO;
import com.robson.back_end.dto.TeamResponseDTO;
import com.robson.back_end.model.Box;
import com.robson.back_end.model.Team;
import com.robson.back_end.repository.BoxRepository;
import com.robson.back_end.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    BoxRepository boxRepository;
    public ResponseEntity<Object> save(TeamRequesDTO teamRequestDTO) {
        Long box_id = teamRequestDTO.getBox_id();

        Optional<Box> optionalBox = boxRepository.findById(box_id);
         if(optionalBox.isEmpty()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado mane!");
         }
        Box box = optionalBox.get();

        Team team = new Team();
        team.setBox(box);
        team.setSchedule(teamRequestDTO.getSchedule());

        return ResponseEntity.status(HttpStatus.CREATED).body(new TeamResponseDTO(teamRepository.save(team)));
    }
}
