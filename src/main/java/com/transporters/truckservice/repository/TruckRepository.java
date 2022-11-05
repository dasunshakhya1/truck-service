package com.transporters.truckservice.repository;

import com.transporters.truckservice.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

    Truck findByRegisterNumber(String registerNumber);
    Truck findByCapacity(double capacity);
    boolean existsByRegisterNumber(String registerNumber);
}
