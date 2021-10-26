package com.ironhack.edgeservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("sales-rep-service")
public interface SalesRepServiceClient {
}
