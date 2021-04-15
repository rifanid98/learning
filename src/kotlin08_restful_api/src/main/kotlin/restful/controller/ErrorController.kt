package restful.controller

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import restful.error.NotFoundException
import restful.error.UnauthorizedException
import restful.model.WebResponse
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(unauthorizedException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "Bad Request",
            data = unauthorizedException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "Not Found",
            data = ""
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun notFound(notFoundException: UnauthorizedException): WebResponse<String> {
        return WebResponse(
            code = 401,
            status = "Unauthorized",
            data = ""
        )
    }

}