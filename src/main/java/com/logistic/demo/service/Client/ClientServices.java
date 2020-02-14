package com.logistic.demo.service.Client;

import com.logistic.demo.shared.dto.ClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientServices {
	Mono<ClientDTO> creatClient(ClientDTO client);
	Flux<ClientDTO>  getClients();
	Mono<ClientDTO> getClient(String clientId);

}
