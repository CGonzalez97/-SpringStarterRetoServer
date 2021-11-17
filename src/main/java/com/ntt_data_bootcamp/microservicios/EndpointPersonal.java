package com.ntt_data_bootcamp.microservicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Endpoint(id="id")
@RestController
public class EndpointPersonal {
	
	@Autowired
	CircuitBreaker cb;
	
	private Integer counter = 0;
	
	@ReadOperation
	public String changeStatus() {
		counter++;
		System.out.println(counter);
		return cb.tryToChangeStatus();
	}
	
}
