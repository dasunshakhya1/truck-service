package com.transporters.truckservice.serviceimpl;

import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;
import com.transporters.truckservice.mappers.TruckMapper;
import com.transporters.truckservice.repository.DepotRepository;
import com.transporters.truckservice.repository.TruckRepository;
import com.transporters.truckservice.service.TruckService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;
    private final DepotRepository depotRepository;


    public TruckServiceImpl(TruckRepository truckRepository, DepotRepository depotRepository) {
        this.truckRepository = truckRepository;

        this.depotRepository = depotRepository;
    }


    @Override
    public Truck findById(Long id) {
        Optional<Truck> optional = truckRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException("Truck with id " + id + " is not found");
    }

    @Override
    public Truck save(Truck truckDto) {
        if (!existByRegisterNumber(truckDto.getRegisterNumber())) {
            Optional<Depot> depotDto = depotRepository.findById(truckDto.getDepotId());
            if (depotDto.isPresent()) {
                truckRepository.save(truckDto);
                return truckDto;
            }
            throw new EntityNotFoundException("The depot with " + truckDto.getDepotId() + " is not found");
        }
        throw new EntityExistsException("Truck with register number " + truckDto.getRegisterNumber() + " is exist");
    }

    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            truckRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("Truck with id " + id + " is not found");
    }

    @Override
    public Truck update(Truck truckDto, Long id) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return truckRepository.existsById(id);
    }

    @Override
    public Set<Truck> findAll() {
        return new HashSet<>(truckRepository.findAll());
    }


    @Override
    public boolean existByRegisterNumber(String registerNumber) {
        return truckRepository.existsByRegisterNumber(registerNumber);
    }

    @Override
    public Truck findByRegisterNumber(String registerNumber) {

        if (existByRegisterNumber(registerNumber)) {
            Optional<Truck> truck = truckRepository.findByRegisterNumber(registerNumber);
            return truck.get();
        }
        throw new EntityNotFoundException("Truck with register number " + registerNumber + " is not found");
    }

    @Override
    public Set<Truck> findByDepotId(Long depotId) {
        return new HashSet<>(truckRepository.findByDepotId(depotId));
    }


}
