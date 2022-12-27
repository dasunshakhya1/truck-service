package com.transporters.truckservice.service;

import com.transporters.truckservice.dto.DepotDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;

import java.util.Set;

public interface DepotService extends AbstractService<Depot,Long> {

    Depot findByName(String name);
    Depot findByShortCord(String shortCOde);
    boolean existsByName(String name);

}
