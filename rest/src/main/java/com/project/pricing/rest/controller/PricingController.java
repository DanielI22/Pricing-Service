package com.project.pricing.rest.controller;

import com.project.pricing.api.model.PricingRequest;
import com.project.pricing.api.model.PricingResponse;
import com.project.pricing.core.interfaces.PricingServiceProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PricingController {
    private final PricingServiceProcessor pricingServiceProcessor;

    public PricingController(PricingServiceProcessor pricingServiceProcessor) {
        this.pricingServiceProcessor = pricingServiceProcessor;
    }

    @PostMapping("/pricing")
    public PricingResponse getTicketPrice(@Valid @RequestBody PricingRequest pricingRequest) {
        return pricingServiceProcessor.getTicketPrice(pricingRequest);
    }
}
