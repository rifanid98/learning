package restful.controller

import org.springframework.web.bind.annotation.*
import restful.model.CreateProductRequest
import restful.model.ProductResponse
import restful.model.WebResponse
import restful.service.ProductService

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProduct") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id);

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

}