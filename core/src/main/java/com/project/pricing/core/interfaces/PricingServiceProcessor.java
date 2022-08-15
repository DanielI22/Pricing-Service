package com.project.pricing.core.interfaces;

import com.project.pricing.api.model.PricingRequest;
import com.project.pricing.api.model.PricingResponse;

public interface PricingServiceProcessor {
    PricingResponse getTicketPrice(PricingRequest pricingRequest);
}
