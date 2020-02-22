package com.logistic.demo.ui.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.demo.service.Client.ClientServices;
import com.logistic.demo.shared.dto.ClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientServices clientServices;

	@PostMapping()
	public @ResponseBody Mono<ClientDTO> addClient(@RequestBody ClientDTO client) {
		return clientServices.creatClient(client);
	}

	@GetMapping()
	public @ResponseBody Flux<ClientDTO> getAllKayaks() {
		return clientServices.getClients();
	}

	@GetMapping(path = "/{clientId}")
	public @ResponseBody Mono<ClientDTO> getUser(@PathVariable String clientId) {
		return clientServices.getClient(clientId);
	}
}
