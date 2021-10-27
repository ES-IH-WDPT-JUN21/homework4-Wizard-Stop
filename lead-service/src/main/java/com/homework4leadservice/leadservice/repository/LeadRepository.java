package com.homework4leadservice.leadservice.repository;

import com.homework4leadservice.leadservice.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
