package org.wayggstar.kampus.entity

import jakarta.persistence.*

@Entity
class Member(
    @Id @GeneratedValue(GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true)
    val email: String,

    var password: String? = null,

    val name: String,

    @Enumerated(EnumType.STRING)
    val role: MemberRole,
)

enum class MemberRole {
    TEACHER,
    STUDENT,
}