package com.transporters.truckservice.serviceimpl;

import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Truck;
import com.transporters.truckservice.repository.TruckRepository;
import com.transporters.truckservice.service.TruckService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;

    public TruckServiceImpl(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }


    @Override
    public TruckDto findById(Long id) {
        Optional<Truck> optional = truckRepository.findById(id);
        if (optional.isPresent()) {
            Truck truck = optional.get();
            return getTruckDto(truck);
        }
        throw new EntityNotFoundException("Truck with id " + id + " is not found");
    }

    @Override
    public TruckDto save(TruckDto truckDto) {
        if (!existByRegisterNumber(truckDto.getRegisterNumber())) {
            Truck truck = truckRepository.save(getTruck(truckDto));
            return getTruckDto(truck);
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
    public TruckDto update(TruckDto truckDto, Long id) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return truckRepository.existsById(id);
    }

    @Override
    public Set<TruckDto> findAll() {
        Set<TruckDto> truckDtos = new HashSet<>();
        truckRepository.findAll().forEach(truck -> truckDtos.add(getTruckDto(truck)));
        return truckDtos;
    }

    private TruckDto getTruckDto(Truck truck) {
        return TruckDto.
                builder().
                id(truck.getId()).
                isFreezer(truck.isFreezer()).
                mileagePerLiter(truck.getMileagePerLiter()).
                registerNumber(truck.getRegisterNumber()).
                capacity(truck.getCapacity()).
                build();
    }

    private Truck getTruck(TruckDto truckDto) {
        return Truck.
                builder().
                isFreezer(truckDto.isFreezer()).
                capacity(truckDto.getCapacity()).
                mileagePerLiter(truckDto.getMileagePerLiter()).
                registerNumber(truckDto.getRegisterNumber()).
                build();
    }

    @Override
    public boolean existByRegisterNumber(String registerNumber) {
        return truckRepository.existsByRegisterNumber(registerNumber);
    }

    @Override
    public TruckDto findByRegisterNumber(String registerNumber) {

        if (existByRegisterNumber(registerNumber)) {
            Truck truck = truckRepository.findByRegisterNumber(registerNumber);
            return getTruckDto(truck);
        }
        throw new EntityNotFoundException("Truck with register number " + registerNumber + " is not found");
    }
}
