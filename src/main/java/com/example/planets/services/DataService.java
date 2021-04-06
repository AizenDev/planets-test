package com.example.planets.services;

import com.example.planets.models.Lord;
import com.example.planets.models.Planet;
import com.example.planets.repositories.LordRepository;
import com.example.planets.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    private LordRepository lordRepository;
    private PlanetRepository planetRepository;

    @Autowired
    public DataService (LordRepository lordRepository, PlanetRepository planetRepository) {
        this.lordRepository = lordRepository;
        this.planetRepository = planetRepository;
    }

    public Optional<Lord> getLordById(Long id) { return lordRepository.findById(id); }

    public Optional<Planet> getPlanetById(Long id) { return planetRepository.findById(id); }

    public Lord addLord(Lord lord) {
        return lordRepository.save(lord);
    }

    public Planet addPlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    public void setLord(Long lord_id, Long planet_id) {
        planetRepository.setPlanetLord(lord_id, planet_id);
    }

    public void destroyPlanet(Long id) {
        planetRepository.deleteById(id);
    }

    public List<String> getLazyLords() {
        return lordRepository.findLazyLords();
    }

    public List<Lord> getYoungestLords() {
        return lordRepository.findYoungestLords();
    }

}
