package org.wayggstar.kampus.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.entity.school.Student
import org.wayggstar.kampus.exceptions.StudentNotFoundException
import org.wayggstar.kampus.repository.schoolrepo.SchoolClassRepository
import org.wayggstar.kampus.repository.schoolrepo.StudentRepository
@Service
@Transactional(readOnly = true)
class StudentService(
    private val studentRepository: StudentRepository,
) {

    /**
     * 신규 학생 등록
     *  @param Student 에 등록할 학생 Entity 객체
     * @return DB에 저장되어 ID 발급될 Student Entity
     */
    @Transactional
    fun registerStudent(student: Student): Student {
        return studentRepository.save(student)
    }

    /**
     * 기존 학생 정보 업데이트
     * JPA의 Dirty Checking을 써서 별도 save 없이 즉각 반영
     * @param ID 수정할 학생 식별자
     * @param updatedData 수정할 데이터 담은 객체
     * @return 수정이 끝난 Student Entity
     * @throws org.wayggstar.kampus.exceptions.StudentNotFoundException 해당 ID 학생 존재하지 않음
     */
    @Transactional
    fun updateStudent(id: Long, updateData: Student): Student {
        val student = studentRepository.findById(id)
            .orElseThrow { StudentNotFoundException(id) }

        student.apply {
            name = updateData.name
            uaeAddress = updateData.uaeAddress
            koreanLevel = updateData.koreanLevel
            currentSchool = updateData.currentSchool
            parentContact = updateData.parentContact
        }

        return student
    }

    /**
     * 특정 학년 학생 목록 조회
     * @param Grade 조화할 Grade Entity
     * @return 해당 Grade에 속한 Student 리스트 (없으면 빈 리스트)
     */
    fun getStudentsByGrade(grade: Grade): List<Student> {
        return studentRepository.findByGrade(grade)
    }

    /**
     * 특정 학생 조회
     * @param ID 조회할 Student Entity
     * @return 해당 ID Student
     * @exception StudentNotFoundException
     */
    fun getStudent(id: Long): Student {
        return studentRepository.findById(id)
            .orElseThrow { StudentNotFoundException(id) }
    }


    /**
     * 시스템에서 학생 정보 삭제
     * @param id 삭제할 학생의 식별자
     * @throws StudentNotFoundException 삭제 대상에 시스템이 없음
     */
    @Transactional
    fun deleteStudent(id: Long) {
        if (!studentRepository.existsById(id)){
            throw StudentNotFoundException(id)
        }
        studentRepository.deleteById(id)
    }
}