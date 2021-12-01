package com.example.demo.repository;

import com.example.demo.model.entities.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepsitory extends JpaRepository<OTP,Integer> {
}
