package com.restapimongodb;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
    Optional<Employee> findByName(String name);
}