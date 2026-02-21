package org.wayggstar.kampus.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.wayggstar.kampus.entity.MemberRole
import org.wayggstar.kampus.service.MemberService

@Controller
class RegisterController(
    private val memberService: MemberService
) {
    @Value("\${kampus.auth.teacher-secret}")
    lateinit var secretCode: String

    @GetMapping("/register")
    fun registerPage() = "register"

    @PostMapping("/register")
    fun register(@RequestParam email: String,
                 @RequestParam password: String,
                 @RequestParam name: String,
                 @RequestParam(required = false) isTeacher: Boolean?,
                @RequestParam(required = false) teacherCode: String?,
                 model: Model
    ): String{

        if (teacherCode != secretCode) {
            model.addAttribute("error", "선생님 인증 코드가 올바르지 않습니다.")
            return "register"
        }
        val role = if (isTeacher == true) MemberRole.TEACHER else MemberRole.STUDENT
        memberService.registerMember(email, password, name, role)
        return "redirect:/login?registered=true"
    }
}