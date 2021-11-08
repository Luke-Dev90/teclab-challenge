package com.teclab.challenge.repository;

import com.teclab.challenge.dto.PupilDTO;
import com.teclab.challenge.entity.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilRepository extends JpaRepository<Pupil,Long> {
    @Query(value = "SELECT * FROM Pupil AS p where p.name =?1", nativeQuery = true)
    Pupil getByName(String name);
}
