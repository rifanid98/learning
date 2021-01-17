package kotlin02_oop.lesson47_reflection

import kotlin02_oop.lesson17_type_check_casts.divider
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

/**
 * Reflection
 *
 * - Reflection adalah kemampuan melihat struktur aplikasi kita pada saat
 *   berjalan.
 * - Reflection biasanya sangat berguna saat kita ingin membuat library
 *   ataupun framework, sehingga bisa meng-otomatisasi pekerjaan .
 * - Untuk mengakses reflection class dari sebuah object, kita bisa
 *   menggunakan kata kunci ::class, atau bisa langsung dari
 *   NamaClass::class.
 */
class ValidationException(message: String): Throwable(message)

//#################################################################
//                        VALIDASI MANUAL
//#################################################################
data class CreateProductRequest1(
    val id: String,
    val name: String,
    val price: Long,
)

data class CreateCategoryRequest1(
    val id: String,
    val name: String
)

fun validateRequestManual(request: CreateProductRequest1) {
    if (request.id == "") {
        throw ValidationException("id is blank")
    } else if (request.name == "") {
        throw ValidationException("name is blank")
    }
}

fun validateRequestManual(request: CreateCategoryRequest1) {
    if (request.id == "") {
        throw ValidationException("id is blank")
    } else if (request.name == "") {
        throw ValidationException("name is blank")
    }
}

fun runValidateRequestManual() {
    /* with no error handling */
//    val request = CreateProductRequest1("", "Indomie", 1000)
//    validateRequestManual(request)

    /* with error handling & get localized message */
    try {
        val request = CreateProductRequest1("", "Indomie", 2000)
        validateRequestManual(request)
    } catch (error: ValidationException) {
        println(error.localizedMessage)
    }
}

//#################################################################
//                    VALIDASI DENGAN REFLECTION
//#################################################################
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class NotBlank()

data class CreateProductRequest2(
    @NotBlank val id: String,
    @NotBlank val name: String,
    val price: Long,
)

data class CreateCategoryRequest2(
    @NotBlank val id: String,
    @NotBlank val name: String
)

fun validateRequestReflection(request: Any) {
    val clazz = request::class
    val properties = clazz.memberProperties

    // iterate satu-persatu, lalu cek kalo ada annotation @NotBlank
    for (property in properties) {
        if (property.findAnnotation<NotBlank>() != null) {
            val value: Any? = property.call(request)
            when (value) {
                is String -> {
                    if (value == "") {
                        throw ValidationException("${property.name} is blank")
                    }
                }
            }
        }
    }
}

fun runValidateRequestReflection() {
    /* with no error handling */
    //val request = CreateProductRequest2("", "Indomie", 2000)
    //validateRequestReflection(request)

    /* with error handling & get localized message */
    try {
        val request = CreateProductRequest2("", "Indomie", 2000)
        validateRequestReflection(request)
    } catch (error: ValidationException) {
        println(error.localizedMessage)
    }
}

fun main() {
    divider("VALIDATION WITH NO RELFECTION", 3 )
    runValidateRequestManual()

    divider("VALIDATION WITH RELFECTION", 3)
    runValidateRequestReflection()
}