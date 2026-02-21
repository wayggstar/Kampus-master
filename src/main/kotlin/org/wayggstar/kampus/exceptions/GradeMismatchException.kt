package org.wayggstar.kampus.exceptions

import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.repository.schoolrepo.SchoolClassRepository

class GradeMismatchException(studentGrade: Grade, schoolClassGrade: Grade) :
    KampusException("학년 불일치: 학생 학년(${studentGrade})과 반 학년(${schoolClassGrade})이 일치하지 않습니다.", "GRADE_MISMATCH")