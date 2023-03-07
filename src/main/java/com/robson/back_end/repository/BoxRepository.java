package com.robson.back_end.repository;

import com.robson.back_end.model.Box;
import com.robson.back_end.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
//import org.springframework.stereotype.Repository;

//@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
    List<Box> findAllByNameIgnoreCase(String name);

    List<Box> findAllByNameContainingIgnoreCaseAndCapacityGreaterThanEqualAndCapacityLessThanEqual(String name, int min, int max);
}
