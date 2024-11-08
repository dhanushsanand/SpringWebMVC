package com.dshivana.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dshivana.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
