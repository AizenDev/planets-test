package com.example.planets.repositories;

import com.example.planets.models.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface LordRepository extends JpaRepository<Lord, Long> {

    @Query(value = "SELECT l.lname FROM lords l LEFT JOIN planets p ON p.lord_id = l.lid WHERE p.pname IS NULL", nativeQuery = true)
    List<String> findLazyLords();


    @Query(value = "SELECT lid, lname, age FROM lords ORDER BY age LIMIT 10",nativeQuery = true)
    List<Lord> findYoungestLords();
}
