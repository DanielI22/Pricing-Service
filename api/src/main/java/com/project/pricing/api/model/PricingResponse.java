package com.project.pricing.api.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricingResponse {
    private Double ticketPrice;
}
