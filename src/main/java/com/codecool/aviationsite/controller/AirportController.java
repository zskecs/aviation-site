package com.codecool.aviationsite.controller;

import com.codecool.aviationsite.dto.AirportDTO;
import com.codecool.aviationsite.entity.Airport;
import com.codecool.aviationsite.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/airports")
public class AirportController {

    AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping()
    public List<Airport> getAllAirports(){
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable("id") String id){
        return airportService.findById(id);
    }

    @GetMapping(params = "minimumNumOfAsphaltRunway")
    public List<Airport> getAirportsByMinimumNumOfAsphaltRunway(@RequestParam int minimumNumOfAsphaltRunway){
        return airportService.getAirportsByMinimumNumOfAsphaltRunway(minimumNumOfAsphaltRunway);
    }

    @GetMapping(params = "minimumNumOfGrassRunway")
    public List<Airport> getAirportsByMinimumNumOfGrassRunway(@RequestParam int minimumNumOfGrassRunway){
        return airportService.getAirportsByMinimumNumOfGrassRunway(minimumNumOfGrassRunway);
    }

    @PostMapping("/{id}")
    public void addAirport(@PathVariable("id") String id, @RequestBody AirportDTO airportDTO){
        airportService.addAirport(airportDTO, id);
    }

    @PutMapping("/{id}")
    public void updateAirport(@PathVariable("id") String id, @RequestBody AirportDTO airportDTO){
        airportService.updateAirport(airportDTO, id);
    }

    @DeleteMapping("/{id}")
    public void  deleteAirport(@PathVariable("id") String id){
        airportService.deleteAirport(id);
    }

}
