package com.covaire.api_rest.service;

import com.covaire.api_rest.model.CarpoolingArea;
import com.covaire.api_rest.repository.CarpoolingAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class CarpoolingAreaService {

    private final CarpoolingAreaRepository repository;

    @Autowired
    public CarpoolingAreaService(CarpoolingAreaRepository carpoolingAreaRepository) {
        this.repository = carpoolingAreaRepository;
    }

    public List<CarpoolingArea> getAllCarpoolingAreas() {
        return repository.findAll();
    }

    public List<String> getAllRegions() {
        return repository.findAll().stream()
                .map(CarpoolingArea::getRegion)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<CarpoolingArea>  getAllCarpoolingAreasByRegion(String region) {
        return repository.findAll().stream()
                .filter(carpoolingArea -> region.equalsIgnoreCase(carpoolingArea.getRegion()))
                .collect(Collectors.toList());
    }
}
