package com.ironhack.edgeservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("lead-service")
public interface LeadServiceClient {
}
