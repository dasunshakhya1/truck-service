package com.transporters.truckservice.serviceimpl;

import com.transporters.truckservice.dto.DepotDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.repository.DepotRepository;
import com.transporters.truckservice.service.DepotService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepotServiceImpl implements DepotService {

    private final DepotRepository depotRepository;

    public DepotServiceImpl(DepotRepository depotRepository) {
        this.depotRepository = depotRepository;
    }

    @Override
    public DepotDto findById(Long aLong) {
        Optional<Depot> optional = depotRepository.findById(aLong);
        if (optional.isPresent()) {
            return getDepotDto(optional.get());
        }
        throw new EntityNotFoundException("Depot with id " + aLong + " not exist");
    }

    @Override
    public DepotDto save(DepotDto depot) {
        if (!existsByName(depot.getName())) {
            Depot dep = depotRepository.save(getDepot(depot));
            return getDepotDto(dep);
        }
        throw new EntityExistsException("Depot with name " + depot.getName() + "sexists");
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public DepotDto update(DepotDto depot, Long aLong) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return depotRepository.existsById(aLong);
    }

    @Override
    public Set<DepotDto> findAll() {
        return depotRepository.findAll().stream().map(this::getDepotDto).collect(Collectors.toSet());
    }

    @Override
    public DepotDto findByName(String name) {
        return null;
    }

    @Override
    public DepotDto findByShortCord(String shortCOde) {
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return depotRepository.existsByName(name);
    }

    private Depot getDepot(DepotDto dto) {
        return Depot.builder().shortCord(dto.getShortCode()).name(dto.getName()).build();
    }

    private DepotDto getDepotDto(Depot depot) {
        return DepotDto.builder().id(depot.getId()).name(depot.getName()).shortCode(depot.getShortCord()).build();
    }
}
