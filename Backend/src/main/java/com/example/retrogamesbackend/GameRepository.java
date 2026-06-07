package com.example.retrogamesbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT g FROM Game g " +
           "WHERE (:title IS NULL OR LOWER(g.title) LIKE LOWER(CONCAT('%', :title, '%'))) " +
           "AND (:dateFrom IS NULL OR g.releaseDate >= :dateFrom) " +
           "AND (:dateTo IS NULL OR g.releaseDate <= :dateTo)")
    List<Game> filterGames(
            @Param("title") String title,
            @Param("dateFrom") LocalDate dateFrom,
            @Param("dateTo") LocalDate dateTo
    );
}
