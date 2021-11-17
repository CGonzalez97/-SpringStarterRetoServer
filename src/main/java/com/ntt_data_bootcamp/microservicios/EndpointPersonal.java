package com.ntt_data_bootcamp.microservicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Endpoint(id="id")
@RestController
public class EndpointPersonal {
	
	@Autowired
	CircuitBreaker cb;
	
	private Integer counter;
	
	@WriteOperation
	public String changeStatus(/*@Selector String status*/) {
		counter++;
		return cb.tryToChangeStatus();
	}
	
}
