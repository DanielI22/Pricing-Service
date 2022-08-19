package com.project.pricing.api.model;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricingRequest {
    @NotNull(message = "The ticketPrice is required")
    private Double ticketBasePrice;
    @NotNull(message = "The ticketType is required")
    private String ticketType;
    @NotNull(message = "The capacity is required")
    @Min(value = 0, message = "Capacity must be greater or equal to 0")
    private Integer capacity;
}
