package org.wayggstar.kampus.exceptions

class StudentNotFoundException(id: Long)
    : KampusException("ID가 ${id}인 학생을 찾을 수 없습니다.", "STUDENT_NOT_FOUND")