package com.transporters.truckservice.service;

import com.transporters.truckservice.dto.DepotDto;
import com.transporters.truckservice.entity.Depot;

public interface DepotService extends AbstractService<DepotDto,Long> {

    DepotDto findByName(String name);
    DepotDto findByShortCord(String shortCOde);

    boolean existsByName(String name);
}
