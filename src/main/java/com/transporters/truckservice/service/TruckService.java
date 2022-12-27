package com.transporters.truckservice.service;

import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;

import java.util.Set;


public interface TruckService extends AbstractService<Truck, Long> {

    boolean existByRegisterNumber(String registerNumber);

    Truck findByRegisterNumber(String registerNumber);
    Set<Truck> findByDepotId(Long depotId);
}
