package com.codecool.aviationsite.repository;

import com.codecool.aviationsite.entity.Airport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AirportRepository {
    List<Airport> airports = new ArrayList(){{
        add(Airport.builder()
                .id("EGLL")
                .name("London Heathrow Airport")
                .numberOfAsphaltRunways(2)
                .numberOfGrassRunways(0).build());
        add(Airport.builder()
                .id("EGLM")
                .name("White Waltham Airfield")
                .numberOfAsphaltRunways(0)
                .numberOfGrassRunways(3).build());
        add(Airport.builder()
                .id("EGSC")
                .name("Cambridge City Airport")
                .numberOfAsphaltRunways(1)
                .numberOfGrassRunways(2).build());

    }};

    public List<Airport> findAllAirport(){
        return airports;
    }

    public void addAirport(Airport airport){
        airports.add(airport);
    }

    public Airport findById(String id){
        return airports.stream()
                .filter(airport -> airport.getId().equals(id))
                .findAny().orElse(null);

    }

    public void deletAirport(String id){
        airports.removeIf(airport -> airport.getId().equals(id));
    }

    public void updateAirport(Airport airport){
        Airport airportToUpdate = findById(airport.getId());
        airportToUpdate.setName(airport.getName());
        airportToUpdate.setNumberOfAsphaltRunways(airport.getNumberOfAsphaltRunways());
        airportToUpdate.setNumberOfGrassRunways(airport.getNumberOfGrassRunways());
    }

    public List<Airport> filterByAsphaltRunways(int minNumOfAsphaltRunways){
       return airports.stream()
               .filter(airport -> airport.getNumberOfAsphaltRunways() >= minNumOfAsphaltRunways)
               .collect(Collectors.toList());
    }

    public List<Airport> filterByGrassRunways(int minNumOfGrassRunways){
        return airports.stream()
                .filter(airport -> airport.getNumberOfGrassRunways() >= minNumOfGrassRunways)
                .collect(Collectors.toList());
    }


}
