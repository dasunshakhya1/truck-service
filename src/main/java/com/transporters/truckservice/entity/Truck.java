package com.transporters.truckservice.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "truck_data")

public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, name = "register_number")
    @Length(min = 6, max = 7)
    private String registerNumber;

    @Column(name = "capacity", nullable = false)
    @Min(6500)
    @Max(14000)
    private BigDecimal capacity;

    @Column(name = "milege_per_liter", nullable = false)
    @Min(3)
    @Max(7)
    private BigDecimal mileagePerLiter;

    @Column(name = "is_freezer", nullable = false)
    private boolean isFreezer;

    @Column(name = "depot_id", nullable = false)
    private Long depotId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return id.equals(truck.id) && registerNumber.equals(truck.registerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registerNumber);
    }
}
