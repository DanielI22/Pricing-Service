package com.project.pricing.core.implementation;

import com.project.pricing.api.model.PricingRequest;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PricingServiceProcessorCoreTest {
    PricingServiceProcessorCore pricingServiceProcessorCore;

    @BeforeEach
    public void setUp(){
        pricingServiceProcessorCore = new PricingServiceProcessorCore();
    }

    @Test
    public void VipTicketWithPriceOf10AndCap20ShouldReturn12() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("VIP").capacity(20).build();
        Assertions.assertEquals(12, pricingServiceProcessorCore.getTicketPrice(pricingRequest).getTicketPrice());
    }

    @Test
    public void InvalidTypeShouldThrowException() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("Invalid").capacity(20).build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> pricingServiceProcessorCore.getTicketPrice(pricingRequest));
    }

    @Test
    public void StandardTicketWithCapLessThan10AndBasePrice10ShouldReturn12() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("Standard").capacity(5).build();
        Assertions.assertEquals(12, pricingServiceProcessorCore.getTicketPrice(pricingRequest).getTicketPrice());
    }
}