package com.transporters.truckservice.repository;

import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface DepotRepository extends JpaRepository<Depot,Long> {
    Optional<Depot> findByName(String name);
    Optional<Depot> findByShortCord(String shortCOde);

    boolean existsByName(String name);

}
