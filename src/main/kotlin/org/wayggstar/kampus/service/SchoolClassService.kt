package org.wayggstar.kampus.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.entity.school.SchoolClass
import org.wayggstar.kampus.entity.school.Student
import org.wayggstar.kampus.exceptions.GradeMismatchException
import org.wayggstar.kampus.repository.schoolrepo.SchoolClassRepository

@Service
class SchoolClassService(
    private val schoolClassRepository: SchoolClassRepository,
) {

    /**
     * 반 생성
     * @param SchoolClass Entity 생성자
     * @return DB에 SchoolClass Entity
     */
    @Transactional
    fun createClass(id: Long, name: String, classroom: String, targetGrade: Grade, teacherName: String): SchoolClass {
        val schoolClass: SchoolClass = SchoolClass(id, name, classroom, targetGrade, teacherName)
        return schoolClass
    }

    /**
     * 학생을 특정 반에 배정. 배정 전 학년 일치 여부를 검증합니다.
     * @param student 배정 대상 학생
     * @param schoolClass 목적지 반
     * @throws GradeMismatchException 학생과 반의 학년이 다를 경우 발생
     */
    @Transactional
    fun assignStudentToClass(student: Student, schoolClass: SchoolClass) {
        if (schoolClass.targetGrade != student.grade) {
            throw GradeMismatchException(student.grade, schoolClass.targetGrade)
        }

        student.schoolClass = schoolClass
    }

    /**
     * 특정 학년 학생 목록 조회
     * @param Grade 조화할 Grade Entity
     * @return 해당 Grade에 속한 SchoolClass 리스트 (없으면 빈 리스트)
     */
    @Transactional
    fun getClassListByGrade(grade: Grade): List<SchoolClass> {
        return schoolClassRepository.findByTargetGrade(grade)
    }
}

