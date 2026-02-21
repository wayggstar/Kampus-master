package org.wayggstar.kampus.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.wayggstar.kampus.entity.school.SchoolClass
import org.wayggstar.kampus.service.SchoolClassService


@RestController
@RequestMapping(path = ["/api/classes"])
class SchoolClassController(private val schoolClassService: SchoolClassService) {

    @PostMapping
    fun createClass(@RequestBody request: SchoolClass): ResponseEntity<SchoolClass> {
        val savedClass = schoolClassService.createClass(
            request.id, request.name, request.classroom!!, request.targetGrade, request.teacherName!!
        )
        return ResponseEntity.ok(savedClass)
    }
}