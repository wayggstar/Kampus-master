package org.wayggstar.kampus.entity.school

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.wayggstar.kampus.entity.school.Grade

@Entity
@Table(name = "classes")
class SchoolClass(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    var classroom: String?,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var targetGrade: Grade,

    var teacherName: String?,

    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    val students: MutableList<Student> = mutableListOf(),
)