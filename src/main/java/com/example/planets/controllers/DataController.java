package com.example.planets.controllers;


import com.example.planets.models.Lord;
import com.example.planets.models.Planet;
import com.example.planets.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DataController {

    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/add_lord")
    public ResponseEntity<Lord> addLord(Lord lord) {
       Lord new_lord = dataService.addLord(lord);
       return ResponseEntity.status(201).body(new_lord);
    }

    @PostMapping("/add_planet")
    public ResponseEntity<Planet> addPlanet(Planet planet) {
        Planet new_planet = dataService.addPlanet(planet);
        return ResponseEntity.status(201).body(new_planet);
    }

    @DeleteMapping("/destroy_planet/{id}")
    public ResponseEntity<Optional<Planet>> deletePlanet(@PathVariable("id") long id) {
        Optional<Planet> planet = dataService.getPlanetById(id);
        dataService.destroyPlanet(id);
        return ResponseEntity.status(201).body(planet);
    }

    @PutMapping("/set_lord")
    public ResponseEntity<Optional<Planet>> setLord(@RequestParam(value = "lordId") Long lordId,
                                          @RequestParam(value = "planetId") Long planetId) {
        Optional<Planet> planet = dataService.getPlanetById(planetId);

        dataService.setLord(lordId, planetId);
        return ResponseEntity.ok().body(planet);
    }

    @GetMapping("/get_lazy_lords")
    public ResponseEntity<List<String>> getLazyLords() {
        List<String> lords = dataService.getLazyLords();
        lords.removeAll(Collections.singleton(null));
        System.out.println(lords);
        return ResponseEntity.ok().body(lords);
    }

    @GetMapping("/get_youngest_lords")
    public ResponseEntity<List<Lord>> getYoungestLords() {
        List<Lord> lords = dataService.getYoungestLords();
        return ResponseEntity.ok().body(lords);
    }


}
