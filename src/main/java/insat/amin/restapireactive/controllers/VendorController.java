package insat.amin.restapireactive.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import insat.amin.restapireactive.domain.Vendor;
import insat.amin.restapireactive.repositories.VendorRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendorController {

	VendorRepository vendorRepository;

	public VendorController(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}
	
@GetMapping("/api/v1/vendors")
public Flux<Vendor> getAll() {
	return vendorRepository.findAll();
}

@GetMapping("api/v1/vendors/{id}")
Mono<Vendor> getById(@PathVariable String id){
    return vendorRepository.findById(id);
}
	
}
