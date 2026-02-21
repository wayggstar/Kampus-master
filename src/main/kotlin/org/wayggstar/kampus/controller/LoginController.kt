package org.wayggstar.kampus.controller

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun loginPage(authentication: Authentication?): String{
        if (authentication != null && authentication.isAuthenticated){
            return "redirect:/main"
        }
        return "login"
    }
}