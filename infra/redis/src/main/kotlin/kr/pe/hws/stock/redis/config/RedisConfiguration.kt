package kr.pe.hws.stock.redis.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
@EntityScan("kr.pe.hws.stock.redis")
@EnableRedisRepositories(basePackages = ["kr.pe.hws.stock.redis"])
class RedisConfiguration(
    @Value("\${spring.data.redis.host}")
    val redisHost: String,
    @Value("\${spring.data.redis.port}")
    val redisPort: Int,
) {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory(redisHost, redisPort)
    }

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<*, *> {
        val template = RedisTemplate<String, String>()
        template.connectionFactory = redisConnectionFactory
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = GenericJackson2JsonRedisSerializer()
        return template
    }
}
