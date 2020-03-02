package com.logistic.demo.service.Client;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.exceptions.GlobalException;
import com.logistic.demo.io.document.Client;
import com.logistic.demo.io.repo.ClientRepo;
import com.logistic.demo.shared.dto.ClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServicesImpl implements ClientServices {
	@Autowired
	private ClientRepo clientRepo;
    
	@Autowired
    private ModelMapper modelMapper;
    
	@Override
	public Mono<ClientDTO> creatClient(ClientDTO clientDTO) {
		String clientId = Generators.timeBasedGenerator().generate().toString();
		clientDTO.setClientId(clientId);
		Client client = modelMapper.map(clientDTO, Client.class);
		return clientRepo.save(client).map(c -> modelMapper.map(c, ClientDTO.class));
	}

	@Override
	public Flux<ClientDTO> getClients() {
		return clientRepo.findAll().map(c -> modelMapper.map(c, ClientDTO.class));
	}

	@Override
	public Mono<ClientDTO> getClient(String clientId) {
		Mono<? extends Client> fallback = Mono.error(new GlobalException(HttpStatus.NOT_FOUND, "invalid client id"));
		return clientRepo.findByClientId(clientId).switchIfEmpty(fallback)
				.map(c -> modelMapper.map(c, ClientDTO.class));
	}/**/

}
