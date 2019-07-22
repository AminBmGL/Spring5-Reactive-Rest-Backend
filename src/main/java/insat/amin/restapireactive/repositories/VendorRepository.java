package insat.amin.restapireactive.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import insat.amin.restapireactive.domain.Vendor;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
