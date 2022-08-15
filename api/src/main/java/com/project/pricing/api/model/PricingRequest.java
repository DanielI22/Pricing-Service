package com.project.pricing.api.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricingRequest {
    private Double ticketBasePrice;
    private String ticketType;
    private Integer capacity;
}
