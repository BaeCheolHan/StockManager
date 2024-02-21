package kr.pe.hws.stock.adapter.feign.config

import feign.Logger
import feign.codec.Decoder
import feign.codec.Encoder
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import java.util.stream.Stream

class StockManagerFeignClientConfig {

    @Bean
    fun encoder(): Encoder = SpringEncoder {
        HttpMessageConverters(
            MappingJackson2HttpMessageConverter().apply {
                supportedMediaTypes = listOf(MediaType.ALL)
            },
        )
    }

    @Bean
    fun decoder(): Decoder = SpringDecoder(
        {
            HttpMessageConverters(
                MappingJackson2HttpMessageConverter().apply {
                    supportedMediaTypes = listOf(MediaType.ALL)
                },
            )
        },
        CustomEmptyObjectProvider(),
    )

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }
}

internal class CustomEmptyObjectProvider : ObjectProvider<HttpMessageConverterCustomizer?> {
    override fun getObject(vararg args: Any): HttpMessageConverterCustomizer {
        return `object`
    }

    override fun getIfAvailable(): HttpMessageConverterCustomizer? {
        return null
    }

    override fun getIfUnique(): HttpMessageConverterCustomizer? {
        return null
    }

    override fun getObject(): HttpMessageConverterCustomizer {
        return HttpMessageConverterCustomizer {
            // do nothing
        }
    }

    override fun stream(): Stream<HttpMessageConverterCustomizer?> {
        return Stream.empty()
    }
}
