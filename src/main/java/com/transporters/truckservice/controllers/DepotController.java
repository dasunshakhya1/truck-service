package com.transporters.truckservice.controllers;


import com.transporters.truckservice.dto.DepotDto;
import com.transporters.truckservice.service.DepotService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/depots")
public class DepotController {

    private final DepotService depotService;

    public DepotController(DepotService depotService) {
        this.depotService = depotService;
    }

    @PostMapping("/new")
    public DepotDto createDepot(@RequestBody DepotDto depotDto){
        return  depotService.save(depotDto);
    }

    @DeleteMapping("/delete/{depotId}")
    public void deleteDepot(@PathVariable("depotId") Long depotId){
        depotService.delete(depotId);
    }
}
