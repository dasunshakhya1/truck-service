package com.transporters.truckservice.repository;

import com.transporters.truckservice.entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotRepository extends JpaRepository<Depot,Long> {
    Depot findByName(String name);
    Depot findByShortCord(String shortCOde);

    boolean existsByName(String name);
}
