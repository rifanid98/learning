package restful.repository

import org.springframework.data.jpa.repository.JpaRepository
import restful.entity.Product

interface ProductRepository : JpaRepository<Product, String> {

}