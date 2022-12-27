package com.transporters.truckservice.controllers;


import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Truck;
import com.transporters.truckservice.mappers.TruckMapper;
import com.transporters.truckservice.service.TruckService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/trucks")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("")
    public Set<TruckDto> getTrucks() {
        return truckService.findAll().stream().map(TruckMapper::getTruckDto).collect(Collectors.toSet());
    }

    @GetMapping("/{id}")
    public TruckDto getTruckById(@PathVariable("id") Long id) {
        return TruckMapper.getTruckDto(truckService.findById(id));
    }

    @GetMapping("/reg/{registerNumber}")
    public TruckDto getTruckByRegisterNumber(@PathVariable("registerNumber") String registerNumber) {
        return TruckMapper.getTruckDto(truckService.findByRegisterNumber(registerNumber));
    }

    @GetMapping("/depot/{depotId}")
    public Set<TruckDto> getTrucksOfDepot(@PathVariable("depotId") Long depotId){
        return  truckService.findByDepotId(depotId).stream().map(TruckMapper::getTruckDto).collect(Collectors.toSet());
    }

    @PostMapping("/new")
    public TruckDto createTruck(@RequestBody TruckDto truckDto) {
        Truck truck =  truckService.save(TruckMapper.getTruck(truckDto));
        return  TruckMapper.getTruckDto(truck);
    }

    @DeleteMapping("/{id}")
    public void deleteTruck(@PathVariable("id") Long id) {
        truckService.delete(id);
    }


}
