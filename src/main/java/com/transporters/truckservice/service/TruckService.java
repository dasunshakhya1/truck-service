package com.transporters.truckservice.service;

import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;

import java.util.Set;


public interface TruckService extends AbstractService<TruckDto, Long> {

    boolean existByRegisterNumber(String registerNumber);

    TruckDto findByRegisterNumber(String registerNumber);
    Set<TruckDto> findByDepotId(Long depotId);
}
