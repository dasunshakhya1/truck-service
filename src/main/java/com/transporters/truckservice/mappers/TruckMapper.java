package com.transporters.truckservice.mappers;

import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;

public class TruckMapper {
    public static TruckDto getTruckDto(Truck truck) {
        return TruckDto.
                builder().
                id(truck.getId()).
                isFreezer(truck.isFreezer()).
                mileagePerLiter(truck.getMileagePerLiter()).
                registerNumber(truck.getRegisterNumber()).
                capacity(truck.getCapacity()).
                depotId(truck.getDepotId()).
                build();
    }

    public static Truck getTruck(TruckDto truckDto) {
        return Truck.
                builder().
                isFreezer(truckDto.isFreezer()).
                capacity(truckDto.getCapacity()).
                mileagePerLiter(truckDto.getMileagePerLiter()).
                registerNumber(truckDto.getRegisterNumber()).
                depotId(truckDto.getDepotId()).
                build();
    }
}
