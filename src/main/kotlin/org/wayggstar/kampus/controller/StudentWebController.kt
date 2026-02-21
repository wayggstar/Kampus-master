package org.wayggstar.kampus.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.wayggstar.kampus.entity.school.Grade
import org.wayggstar.kampus.service.StudentService

@Controller
class StudentWebController(
    private val studentService: StudentService,
) {

    @GetMapping("/students")
    fun listStudentsByGrade(
        @RequestParam(defaultValue = "G1") grade: Grade,
        model: Model): String {
        val students = studentService.getStudentsByGrade(grade)

        model.addAttribute("students", students)
        model.addAttribute("currentGrade", grade)
        model.addAttribute("grades", Grade.entries.toTypedArray())

        return "students"
    }
}