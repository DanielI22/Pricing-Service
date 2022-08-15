package com.project.pricing.core.implementation;

import com.project.pricing.api.model.PricingRequest;
import com.project.pricing.api.model.PricingResponse;
import com.project.pricing.core.interfaces.PricingServiceProcessor;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceProcessorImpl implements PricingServiceProcessor {
    private final PriceCalculator priceCalculator;

    public PricingServiceProcessorImpl(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    @Override
    public PricingResponse getTicketPrice(PricingRequest pricingRequest) {
        return PricingResponse.builder()
                .ticketPrice(priceCalculator.getPrice(pricingRequest))
                .build();
    }
}
