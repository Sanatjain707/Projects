package com.Management.SM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Management.SM.Entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
