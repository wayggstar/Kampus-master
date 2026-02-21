package org.wayggstar.kampus.entity.notice

import jakarta.persistence.*
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.entity.school.SchoolClass
import java.time.LocalDateTime

@Entity
@Table(name = "notices")
class Notice(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String,

    var author: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "target_grade")
    var targetGrade: Grade? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    var targetClass: SchoolClass? = null,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
)