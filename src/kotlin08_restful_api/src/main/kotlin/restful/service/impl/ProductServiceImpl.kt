package restful.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import restful.entity.Product
import restful.error.NotFoundException
import restful.helper.Validation
import restful.model.CreateProductRequest
import restful.model.ListProductRequest
import restful.model.ProductResponse
import restful.model.UpdateProductRequest
import restful.repository.ProductRepository
import restful.service.ProductService
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validation: Validation
) : ProductService {

    /**
     * Create one product
     * @param createProductRequest
     * @return ProductResponse
     */
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {

        validation.validate(createProductRequest);

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null,
        )

        productRepository.save(product)

        return this.handleResponse(product)
    }

    /**
     * Update product
     * @param id String
     * @param updateProductRequest
     * @return ProductResponse
     */
    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = this.findProductById(id)

        validation.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        productRepository.save(product)

        return this.handleResponse(product)
    }

    /**
     * Get all products
     * @param id String
     * @return ProductResponse
     */
    override fun get(id: String): ProductResponse {
        val product = this.findProductById(id)

        if (product == null) {
            throw NotFoundException()
        } else {
            return this.handleResponse(product)
        }
    }

    /**
     * Get list products
     * @param listProductRequest
     * @return List<ProductResponse>
     */
    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val datas = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products: List<Product> = datas.get().collect(Collectors.toList())

        return products.map { this.handleResponse(it) }
    }

    /**
     * Delete product
     * @param id String
     * @return
     */
    override fun delete(id: String) {
        val product = this.findProductById(id)
        productRepository.delete(product)
    }

    /**
     * Handle find product by id
     */
    private fun findProductById(id: String): Product {
        val product = productRepository.findByIdOrNull(id)

        if (product == null) {
            throw NotFoundException()
        }

        return product
    }

    /**
     * Handle Product Response
     */
    private fun handleResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }

}