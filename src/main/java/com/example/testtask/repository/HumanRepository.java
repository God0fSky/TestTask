package com.example.testtask.repository;

import com.example.testtask.model.Human;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Created by olegb on март, 2023
 */

@Repository
public interface HumanRepository extends CrudRepository<Human, Integer> {

    Optional<Human> findById(int id);

}
