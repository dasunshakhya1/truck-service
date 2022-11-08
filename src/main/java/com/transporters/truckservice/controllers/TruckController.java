package com.transporters.truckservice.controllers;


import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.service.TruckService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("v1/api/trucks")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("")
    public Set<TruckDto> getTrucks() {
        return truckService.findAll();
    }

    @GetMapping("/{id}")
    public TruckDto getTruckById(@PathVariable("id") Long id) {
        return truckService.findById(id);
    }

    @GetMapping("/reg/{registerNumber}")
    public TruckDto getTruckByRegisterNumber(@PathVariable("registerNumber") String registerNumber) {
        return truckService.findByRegisterNumber(registerNumber);
    }

    @GetMapping("/depot/{depotId}")
    public Set<TruckDto> getTrucksOfDepot(@PathVariable("depotId") Long depotId){
        return  truckService.findByDepotId(depotId);
    }

    @PostMapping("/new")
    public TruckDto createTruck(@RequestBody TruckDto truckDto) {
        return truckService.save(truckDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTruck(@PathVariable("id") Long id) {
        truckService.delete(id);
    }


}
