package com.project.pricing.api.feign;

import com.project.pricing.api.model.PricingRequest;
import com.project.pricing.api.model.PricingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "PRICING-SERVICE", url = "http://localhost:8091")
public interface PricingClient {
    @RequestMapping(method = RequestMethod.GET, value = "/pricing/")
    PricingResponse calculateTicketPrice(@RequestBody PricingRequest pricingRequest);
}
