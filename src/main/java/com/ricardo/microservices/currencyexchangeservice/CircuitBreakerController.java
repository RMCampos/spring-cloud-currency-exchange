package com.ricardo.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @GetMapping("/sample-api")
  //@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
  //@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
  @RateLimiter(name = "default")
  // 10s => 10000 calls to the sample api
  //@Bulkhead(name = "default")
  public String sampleApi() {
    logger.info("Sample Api call received");
    /*
    ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/non-existing-url", String.class);
    return response.getBody();
    */
    return "Sample-api";
  }

  public String hardcodedResponse(Exception ex) {
    return "Fallback-response";
  }
}
