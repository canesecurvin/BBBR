package com.example.capstone.bbbr.repositories;

import com.example.capstone.bbbr.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
}
