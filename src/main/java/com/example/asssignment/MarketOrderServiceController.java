package com.example.asssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MarketOrderServiceController {
	
	 @Autowired
	  Environment environment;
	 
	 @Autowired
	 MarketOrderService marketOrderService;
	 
	  @GetMapping("/")
	  public String health() {
	    return "I am Ok";
	  }
	 
	  @GetMapping("/backend")
	  public String backend() {
	    System.out.println("Inside AcctTransactionController::backend...");
	    String serverPort = environment.getProperty("local.server.port");
	    System.out.println("Port : " + serverPort);
	    return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	    
	    
	  }
	  
	  @GetMapping("/api/marketorder")
	  public String getAllStocks() throws JsonProcessingException {
		  System.out.println("Get all the stocks");
		  Flux<MarketOrder> marketOrders = marketOrderService.getAll();
		  ObjectMapper objectMapper = new ObjectMapper();
		  String jsonString = objectMapper.writeValueAsString(marketOrders);
		  return jsonString;
	  }
	  
	  @PostMapping("/api/marketorder")
		public String saveStock(@RequestBody MarketOrder market) throws JsonProcessingException {
			System.out.println("Save the stock");
			ObjectMapper objectMapper = new ObjectMapper();
		    String jsonString = objectMapper.writeValueAsString(marketOrderService.save(market).block());
		    return jsonString;
		}
	  
	  @PutMapping("/api/marketorder/confirm/{id}")
	  public String confirmOrder(@PathVariable String id) throws JsonProcessingException {
	    Mono<MarketOrder> confirmedOrder = marketOrderService.getById(id)
	      .flatMap(order -> {
	        order.setStatus("CONFIRMED");
	        return marketOrderService.orderTransactionConfirmation(order);
	      });
	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonString = objectMapper.writeValueAsString(confirmedOrder.block());
	    return jsonString;
	  }

}
