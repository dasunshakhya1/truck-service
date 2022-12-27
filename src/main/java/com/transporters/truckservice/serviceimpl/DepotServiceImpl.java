package com.transporters.truckservice.serviceimpl;

import com.transporters.truckservice.dto.DepotDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;
import com.transporters.truckservice.exceptions.NonEmptyDepotException;
import com.transporters.truckservice.mappers.DepotMapper;
import com.transporters.truckservice.repository.DepotRepository;
import com.transporters.truckservice.repository.TruckRepository;
import com.transporters.truckservice.service.DepotService;
import com.transporters.truckservice.service.TruckService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepotServiceImpl implements DepotService {

    private final DepotRepository depotRepository;
    private final TruckRepository truckRepository;

    public DepotServiceImpl(DepotRepository depotRepository, TruckService truckService, TruckRepository truckRepository) {
        this.depotRepository = depotRepository;

        this.truckRepository = truckRepository;
    }

    @Override
    public Depot findById(Long aLong) {
        Optional<Depot> optional = depotRepository.findById(aLong);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException("Depot with id " + aLong + " not exist");
    }

    @Override
    public Depot save(Depot depot) {
        if (!existsByName(depot.getName())) {
                return depotRepository.save(depot);
        }
        throw new EntityExistsException("Depot with name " + depot.getName() + "exists");
    }

    @Override
    public void delete(Long aLong) {
        if (existsById(aLong)) {
            Set<Truck> trucks = truckRepository.findByDepotId(aLong);

            if (trucks.size() > 0) {
                throw new NonEmptyDepotException("Depot with id "+aLong+ " has " + trucks.size() + " trucks");
            } else {
                depotRepository.deleteById(aLong);
            }

        }
        throw new EntityNotFoundException("Depot with id " + aLong + " not exist");
    }

    @Override
    public Depot update(Depot depot, Long aLong) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return depotRepository.existsById(aLong);
    }

    @Override
    public Set<Depot> findAll() {
        return  new HashSet<>(depotRepository.findAll());
    }

    @Override
    public Depot findByName(String name) {

        Optional<Depot> depot = depotRepository.findByName(name);
        if (depot.isEmpty()) {
            throw new EntityNotFoundException("Depot with name " + name + " not exist");
        }
        return depot.get();
    }

    @Override
    public Depot findByShortCord(String shortCOde) {
        Optional<Depot> depot = depotRepository.findByShortCord(shortCOde);
        if (depot.isEmpty()) {
            throw new EntityNotFoundException("Depot with short code " + shortCOde + " not exist");
        }
        return depot.get();
    }

    @Override
    public boolean existsByName(String name) {
        return depotRepository.existsByName(name);
    }


}
