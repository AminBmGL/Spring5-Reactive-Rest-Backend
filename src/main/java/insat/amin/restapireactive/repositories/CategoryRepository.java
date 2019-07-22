package insat.amin.restapireactive.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import insat.amin.restapireactive.domain.Category;

public interface CategoryRepository extends ReactiveMongoRepository <Category, String>{
}	
