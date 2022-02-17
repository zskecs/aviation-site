package com.codecool.aviationsite.service;

import com.codecool.aviationsite.dto.AirportDTO;
import com.codecool.aviationsite.entity.Airport;
import com.codecool.aviationsite.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findAll(){
        return airportRepository.findAllAirport();
    }

    public Airport findById(String id){
        return airportRepository.findById(id);
    }

    public List<Airport> getAirportsByMinimumNumOfAsphaltRunway(int minimumNumOfAsphaltRunway){
        return airportRepository.filterByAsphaltRunways(minimumNumOfAsphaltRunway);
    }

    public List<Airport> getAirportsByMinimumNumOfGrassRunway(int minimumNumOfGrassRunway){
        return airportRepository.filterByGrassRunways(minimumNumOfGrassRunway);
    }

    public void addAirport(AirportDTO airportDTO, String id){
        airportRepository.addAirport(new Airport(id, airportDTO));
    }

    public void updateAirport(AirportDTO airportDTO, String id){
        airportRepository.updateAirport(new Airport(id, airportDTO));
    }

    public void deleteAirport(String id){
        airportRepository.deletAirport(id);
    }
}
