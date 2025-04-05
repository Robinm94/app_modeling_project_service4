package com.example.asssignment;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface MarketOrderRepository extends ReactiveMongoRepository<MarketOrder, String> {
	Mono<MarketOrder> findByTransactionIdAndOrderId(String transactionId, String orderId);;

}
