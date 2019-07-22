package insat.amin.restapireactive.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import insat.amin.restapireactive.domain.Vendor;
import insat.amin.restapireactive.repositories.VendorRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VendorControllerTest {

	VendorRepository vendorRepository;
	VendorController vendorController;
	WebTestClient webTestClient;
	@Before
	public void setUp() throws Exception {
		vendorRepository=Mockito.mock(VendorRepository.class);
		vendorController=new VendorController(vendorRepository);
		webTestClient=WebTestClient.bindToController(vendorController).build();
	}

	@Test
	public void testGetAll() {
		BDDMockito.given(vendorRepository.findAll())
		.willReturn(Flux.just(Vendor.builder().firstName("Amin").lastName("Mbarek").build(),
				Vendor.builder().firstName("Ayoub").lastName("Mbarek").build()));
		
		webTestClient.get()
		.uri("/api/v1/vendors")
		.exchange()
		.expectBodyList(Vendor.class)
		.hasSize(2);
	}
	
	@Test
    public void getById() {
        BDDMockito.given(vendorRepository.findById("someid"))
                .willReturn(Mono.just(Vendor.builder().firstName("Ahmed").lastName("Mbarek").build()));

        webTestClient.get()
                .uri("/api/v1/vendors/someid")
                .exchange()
                .expectBody(Vendor.class);
    }

}
