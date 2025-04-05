package com.example.asssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MarketOrderService {
	
	@Autowired
	private MarketOrderRepository marketOrderRepository;
	
	public Mono<MarketOrder> save(MarketOrder marketOrder) {
		return marketOrderRepository.save(marketOrder);
	}
	
	public Mono<MarketOrder> findByTransactionIdAndOrderId(String transactionId, String orderId) {
		return marketOrderRepository.findByTransactionIdAndOrderId(transactionId, orderId);
	}
	
	public Mono<MarketOrder> getById(String id) {
		return marketOrderRepository.findById(id);
	}
	
	public Mono<Void> deleteById(String id) {
		return marketOrderRepository.deleteById(id);
	}
	
	public Mono<MarketOrder> update(MarketOrder marketOrder) {
		return marketOrderRepository.save(marketOrder);
	}
	
	public Flux<MarketOrder> getAll() {
		return marketOrderRepository.findAll();
	}
	
	public Mono<MarketOrder> orderTransactionConfirmation(MarketOrder marketOrder) {
		return marketOrderRepository.save(marketOrder).flatMap(savedOrder -> {
			savedOrder.setStatus("CONFIRMED");
			return Mono.just(savedOrder);
		});
	}
}
