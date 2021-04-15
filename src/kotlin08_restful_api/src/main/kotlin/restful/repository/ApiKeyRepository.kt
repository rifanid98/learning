package restful.repository

import org.springframework.data.jpa.repository.JpaRepository
import restful.entity.ApiKey

interface ApiKeyRepository: JpaRepository<ApiKey, String> {
}