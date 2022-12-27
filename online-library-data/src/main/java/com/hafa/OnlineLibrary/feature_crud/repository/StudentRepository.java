package com.hafa.OnlineLibrary.feature_crud.repository;


import com.hafa.OnlineLibrary.feature_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
