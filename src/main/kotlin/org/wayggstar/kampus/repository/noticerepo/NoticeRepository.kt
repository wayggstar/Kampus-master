package org.wayggstar.kampus.repository.noticerepo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.wayggstar.kampus.entity.notice.Notice
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.entity.school.SchoolClass

@Repository
interface NoticeRepository: JpaRepository<Notice, Long> {
    fun findByTargetGradeIsNullAndTargetClassIsNull(): List<Notice>

    fun findByTargetGradeOrTargetClassOrIdIn(grade: Grade?, schoolClass: SchoolClass?, ids: List<Long>): List<Notice>

    fun findAllByOrderByCreatedAtDesc(): List<Notice>
}