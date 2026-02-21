package org.wayggstar.kampus.entity.school

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.wayggstar.kampus.entity.Member
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.entity.school.SchoolClass

@Entity
@Table(name = "students")
class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String,

    @Enumerated(EnumType.STRING)
    var gender: Gender,

    var photoUrl: String? = null,

    var nationality: String,

    var birthYear: Int,

    @Enumerated(EnumType.STRING)
    var grade: Grade,

    var uaeAddress: String,

    var currentSchool: String,

    var koreanLevel: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    var schoolClass: SchoolClass? = null,

    @Column(name = "parent_contact", length = 30)
    var parentContact: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member? = null,
)