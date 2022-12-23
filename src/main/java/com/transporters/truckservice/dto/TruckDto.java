package com.transporters.truckservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TruckDto {

    private Long id;

    @Length(min = 6, max = 7)
    @NotNull
    private String registerNumber;

    @Min(6500)
    @Max(14000)
    @NotNull
    private double capacity;

    @Min(3)
    @Max(7)
    @NotNull
    private double mileagePerLiter;

    @NotNull
    private boolean isFreezer;

    @NotNull
    private Long depotId;
}
