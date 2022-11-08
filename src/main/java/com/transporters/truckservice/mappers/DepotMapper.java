package com.transporters.truckservice.mappers;

import com.transporters.truckservice.dto.DepotDto;
import com.transporters.truckservice.entity.Depot;

public class DepotMapper {


    public static Depot getDepot(DepotDto dto) {
        return Depot.builder().shortCord(dto.getShortCode()).name(dto.getName()).build();
    }

    public static DepotDto getDepotDto(Depot depot) {
        return DepotDto.builder().id(depot.getId()).name(depot.getName()).shortCode(depot.getShortCord()).build();
    }
}
