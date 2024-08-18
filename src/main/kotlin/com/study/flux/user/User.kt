package com.study.flux.user

import com.study.flux.common.AbstractEntity
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "table_user")
class User(
    @Id
    @Column("id")
    val id: Long?,
    @Column("name")
    val name: String,
    @Column("age")
    val age: Int,
    @Column("sex")
    val sex: Sex,
) : AbstractEntity() {
    enum class Sex {
        MALE,
        FEMALE,
    }

    companion object {
        fun of(
            name: String,
            age: Int,
            sex: Sex,
        ): User =
            User(
                id = null,
                name = name,
                age = age,
                sex = sex,
            )
    }
}
