package kr.pe.hws.stock.rdb.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    val createdDate: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    val updatedDate: LocalDateTime = LocalDateTime.now()
}
