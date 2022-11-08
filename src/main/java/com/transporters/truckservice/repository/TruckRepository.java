package com.transporters.truckservice.repository;

import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

    Optional<Truck> findByRegisterNumber(String registerNumber);
    Optional<Truck> findByCapacity(double capacity);
    boolean existsByRegisterNumber(String registerNumber);

    Set<Truck> findByDepotId(Long depotId);

}
