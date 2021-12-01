package com.example.demo.repository;

import com.example.demo.model.entities.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface AdminRepsitory extends JpaRepository<Admin, Integer> {
    //Page<Admin> findAllByName(String name);

    List<Admin> findAllByName(String name);
}
