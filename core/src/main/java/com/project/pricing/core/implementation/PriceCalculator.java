package com.project.pricing.core.implementation;

import com.project.pricing.api.model.PricingRequest;
import com.project.pricing.data.TicketType;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculator {
    public Double getPrice(PricingRequest pricingRequest) {
        Double ticketPrice = switch (TicketType.valueOf(pricingRequest.getTicketType().toUpperCase())) {
            case STANDARD -> pricingRequest.getTicketBasePrice();
            case VIP -> pricingRequest.getTicketBasePrice() * 1.2;
            case PENSIONER -> pricingRequest.getTicketBasePrice() * 0.7;
            case CHILDREN -> pricingRequest.getTicketBasePrice() * 0.8;
            case STUDENT -> pricingRequest.getTicketBasePrice() * 0.9;
        };

        if(pricingRequest.getCapacity() < 10) {
            ticketPrice = ticketPrice * 1.2;
        }
        return (double)Math.round(ticketPrice*100)/100;
    }
}
