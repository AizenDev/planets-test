package com.example.planets.repositories;


import com.example.planets.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

   @Query(value = "UPDATE planets p SET p.lord_id = :lord_id WHERE p.pid = :id", nativeQuery = true)
   Planet setPlanetLord(@Param("lord_id") Long lord_id, @Param("id") Long planet_id);

}
