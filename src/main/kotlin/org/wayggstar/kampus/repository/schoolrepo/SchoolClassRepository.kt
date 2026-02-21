package org.wayggstar.kampus.repository.schoolrepo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.entity.school.SchoolClass

@Repository
interface SchoolClassRepository: JpaRepository<SchoolClass, Long> {
    fun findByTargetGrade(targetGrade: Grade): List<SchoolClass>
}