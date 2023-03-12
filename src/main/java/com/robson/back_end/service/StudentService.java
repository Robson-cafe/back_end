package com.robson.back_end.service;

import com.robson.back_end.dto.ClientRequestDTO;
import com.robson.back_end.dto.ClientResponsyDTO;
import com.robson.back_end.dto.StudentRequestDTO;
import com.robson.back_end.dto.StudentResponseDTO;
import com.robson.back_end.model.Client;
import com.robson.back_end.model.Student;
import com.robson.back_end.repository.ClientRepository;
import com.robson.back_end.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClientRepository clientRepository;
    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO) {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, clientRequestDTO);

        Client client = clientRequestDTO.toClient();
        clientRepository.save(client);

        Student student = new Student();

        student.setRegistration("222323232");
        student.setPaid(false);
        student.setClient(client);

        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new StudentResponseDTO(studentOptional.get()));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado.");
        }
    }
}
