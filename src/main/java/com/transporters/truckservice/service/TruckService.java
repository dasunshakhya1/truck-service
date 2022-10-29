package com.transporters.truckservice.service;

import com.transporters.truckservice.dto.TruckDto;


public interface TruckService extends AbstractService<TruckDto, Long> {

    boolean existByRegisterNumber(String registerNumber);

    TruckDto findByRegisterNumber(String registerNumber);

}
