package kotlin02_oop.lesson46_annotation_target

/**
 * Annotation Target
 *
 * - Kotlin Annotation berjalan baik dengan Java Annotation.
 * - Namun kadang kita ingin menempatkan posisi annotation sesuai dengan
 *   yang kita mau agar bisa terbaca di Java dengan baik.
 * - Biasanya kejadian ini terjadi ketika kita menggunakan Kotlin, namun
 *   menggunakan framework Java, sehingga target lokasi Annotation nya
 *   harus sesuai dengan yang biasa digunakan framework tersebut di Java.
 * - Di kotlin kita bisa menggunakan @target:NamaAnnotation nya untuk
 *   menentukan lokasi target Annotation akan ditempatkan dimana.
 */
@Target(AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.FIELD,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Beta

class ExampleTarget(
    @field:Beta val firstName: String,
    @get:Beta val middleName: String,
    @param:Beta val lastName: String,
)