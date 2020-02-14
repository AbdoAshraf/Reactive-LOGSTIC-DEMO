package com.logistic.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.demo.io.domain.Client;
import com.logistic.demo.io.repo.ClientRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientRepo cr;
	
	@PostMapping()  
    public @ResponseBody  
    Mono<Client> addClient(@RequestBody Client client) {  
        return cr.save(client);
    }  
	
	@GetMapping()  
    public @ResponseBody
    Flux<Client> getAllKayaks() {  
        return cr.findAll();  
    }

}
