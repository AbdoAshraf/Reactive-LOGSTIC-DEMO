package com.logistic.demo.service.Client;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.io.domain.Client;
import com.logistic.demo.io.repo.ClientRepo;
import com.logistic.demo.shared.dto.ClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ClientServicesImpl implements ClientServices{
	@Autowired
    private ClientRepo clientRepo;
	@Override
	public Mono<ClientDTO> creatClient(ClientDTO clientDTO) {
		String timebaseUUID =  Generators.timeBasedGenerator().generate().toString();
		clientDTO.setClientId(timebaseUUID);
		ModelMapper modelMapper = new ModelMapper();
		Client client = modelMapper.map(clientDTO, Client.class);
		return clientRepo.save(client).map(c -> modelMapper.map(c, ClientDTO.class));
	}

	@Override
	public Flux<ClientDTO> getClients() {
		ModelMapper modelMapper = new ModelMapper();
		return clientRepo.findAll().map(c -> modelMapper.map(c, ClientDTO.class));
	}

	@Override
	public Mono<ClientDTO> getClient(String clientId) {
		ModelMapper modelMapper = new ModelMapper();
		return clientRepo.findByClientId(clientId).map(c -> modelMapper.map(c, ClientDTO.class));
	}/**/


}
