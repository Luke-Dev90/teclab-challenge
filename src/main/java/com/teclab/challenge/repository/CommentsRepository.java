package com.teclab.challenge.repository;

import com.teclab.challenge.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment,Long> {
    @Modifying
    @Query(value = "DELETE FROM Comment as C where C.career_id =?1",nativeQuery = true)
    void getCommentByIdCareer(Long id);
    @Modifying
    @Query(value = "DELETE FROM Comment as C where C.pupil_id =?1",nativeQuery = true)
    void getCommentByIdPupil(Long id);
}
