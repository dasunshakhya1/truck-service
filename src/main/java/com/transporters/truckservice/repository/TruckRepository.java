package com.transporters.truckservice.repository;

import com.transporters.truckservice.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

    Optional<Truck> findById(Long uuid);

    Truck findByRegisterNumber(String registerNumber);

    Truck findByCapacity(double capacity);

    boolean existsByRegisterNumber(String registerNumber);
}
