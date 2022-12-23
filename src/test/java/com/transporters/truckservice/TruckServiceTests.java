package com.transporters.truckservice;

import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;
import com.transporters.truckservice.repository.DepotRepository;
import com.transporters.truckservice.repository.TruckRepository;
import com.transporters.truckservice.serviceimpl.TruckServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TruckServiceTests {

    @Mock
    private TruckRepository truckRepository;
    @Mock
    private DepotRepository depotRepository;

    @InjectMocks
    private TruckServiceImpl truckService;
    static Truck truck;
    static TruckDto truckDto;
    static Depot depot;

    @BeforeAll
    public static void setup() {
        truck = new Truck(122112112L, "WE12309", 4.5, 5, false, 124L);
        truckDto = new TruckDto(122112112L, "WE12309", 4.5, 5, false, 124L);
        depot = new Depot(124L, "Test Depot", "TDP");
    }

    @Test
    public void testFindById() {
        when(truckRepository.findById(122112112L)).thenReturn(Optional.of(truck));
        TruckDto truckDto = truckService.findById(122112112L);
        assertThat(truckDto.getId()).isEqualTo(122112112L);
    }

    @Test
    public void testSave() {
        when(truckRepository.existsByRegisterNumber("WE12309")).thenReturn(false);
        when(depotRepository.findById(truckDto.getDepotId())).thenReturn(Optional.ofNullable(depot));
        TruckDto tdto = truckService.save(truckDto);
        assertThat(tdto.getId()).isEqualTo(122112112L);
    }

}
