package com.project.pricing.core.implementation;

import com.project.pricing.api.model.PricingRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PricingServiceProcessorCoreTest {
    private PricingServiceProcessorCore pricingServiceProcessorCore;

    @BeforeEach
    public void setUp(){
        pricingServiceProcessorCore = new PricingServiceProcessorCore();
    }

    @Test
    public void InvalidTypeShouldThrowException() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("Invalid").capacity(20).build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> pricingServiceProcessorCore.getTicketPrice(pricingRequest));
    }

    @Test
    public void VipTicketWithPriceOf10AndCap20ShouldReturn12() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("VIP").capacity(20).build();
        Assertions.assertEquals(12, pricingServiceProcessorCore.getTicketPrice(pricingRequest).getTicketPrice());
    }

    @Test
    public void StandardTicketWithCap5AndBasePrice10ShouldReturn12() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("Standard").capacity(5).build();
        Assertions.assertEquals(12, pricingServiceProcessorCore.getTicketPrice(pricingRequest).getTicketPrice());
    }

    @Test
    public void StudentTicketWithCap20AndBasePrice10ShouldReturn9() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("Student").capacity(20).build();
        Assertions.assertEquals(9, pricingServiceProcessorCore.getTicketPrice(pricingRequest).getTicketPrice());
    }

    @Test
    public void PensionerTicketWithCap20AndBasePrice10ShouldReturn7() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("Pensioner").capacity(20).build();
        Assertions.assertEquals(7, pricingServiceProcessorCore.getTicketPrice(pricingRequest).getTicketPrice());
    }

    @Test
    public void ChildrenTicketWithCap5AndBasePrice10ShouldReturn8() {
        var pricingRequest = PricingRequest.builder().ticketBasePrice(10.).ticketType("Children").capacity(10).build();
        Assertions.assertEquals(8, pricingServiceProcessorCore.getTicketPrice(pricingRequest).getTicketPrice());
    }
}