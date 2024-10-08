package com.study.flux.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

abstract class AbstractEntity {
    @CreatedDate
    @Column("created_at")
    var createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column("updated_at")
    var updatedAt: LocalDateTime? = null
}
