package org.wayggstar.kampus.repository.schoolrepo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.entity.school.SchoolClass
import org.wayggstar.kampus.entity.school.Student

@Repository
interface StudentRepository: JpaRepository<Student, Long> {
    fun findByGrade(targetGrade: Grade): List<Student>
    fun findBySchoolClass(targetClass: SchoolClass): List<Student>
    fun findByName(name: String): List<Student>
}