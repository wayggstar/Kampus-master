package org.wayggstar.kampus.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.wayggstar.kampus.entity.school.Student
import org.wayggstar.kampus.service.StudentService

/**
 * Student API 관련 요청 Controller
 * @property studentService
 */

@RestController
@RequestMapping(path = ["/api/students"])
class StudentController(
    private val studentService: StudentService
){

    /**
     * 신규 Student 등록 API
     * POST /api/students
     */
    @PostMapping
    fun registerStudent(@RequestBody student: Student): ResponseEntity<Student> {
        val savedStudent = studentService.registerStudent(student)
        return ResponseEntity.ok(savedStudent)
    }

    /**
     * Student 정보 조회 API
     * GET /api/students/{id}
     */
    @GetMapping("/{id}")
    fun getStudentById(@PathVariable("id") id: Long): ResponseEntity<Student> {
        val student = studentService.getStudent(id)
        return ResponseEntity.ok(student)
    }

    /**
     * Student 정보 수정 API
     * PUT /api/students/{id}
     */
    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable("id") id: Long,
        @RequestBody updateData: Student
    ): ResponseEntity<Student> {
        val updatedStudent = studentService.updateStudent(id, updateData)
        return ResponseEntity.ok(updatedStudent)
    }

    /**
     * Student 정보 삭제 API
     * DELETE /api/students/{id{
     */
    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable("id") id: Long): ResponseEntity<Void> {
        studentService.deleteStudent(id)
        return ResponseEntity.noContent().build()
    }

}