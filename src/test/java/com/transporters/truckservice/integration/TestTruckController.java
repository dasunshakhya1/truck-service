package com.transporters.truckservice.integration;


import com.transporters.truckservice.controllers.TruckController;
import com.transporters.truckservice.dto.TruckDto;
import com.transporters.truckservice.entity.Depot;
import com.transporters.truckservice.entity.Truck;
import com.transporters.truckservice.service.TruckService;
import org.hibernate.action.internal.EntityActionVetoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityNotFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TruckController.class)
public class TestTruckController {


    @MockBean
    private TruckService truckService;

    @Autowired
    private MockMvc mockMvc;



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
    public void testFindById() throws Exception {
        when(truckService.findById(122112112L)).thenReturn(truck);
        mockMvc.perform(get("/v1/api/trucks/{id}",122112112L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    @Test
    public void testFindByIdError() throws Exception {
        when(truckService.findById(122112112L)).thenThrow(EntityNotFoundException.class);
        mockMvc.perform(get("/v1/api/trucks/{id}",122112112L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }
}
