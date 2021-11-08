package com.teclab.challenge.repository;

import com.teclab.challenge.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career,Long> {
}
