package org.wayggstar.kampus.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.wayggstar.kampus.entity.Member
import org.wayggstar.kampus.entity.MemberRole
import org.wayggstar.kampus.repository.MemberRepository

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun registerMember(email: String, password: String?, name: String, role: MemberRole): Member {
        val encodedPassword = password?.let { passwordEncoder.encode(it) }
        val member = Member(
            email = email,
            password = encodedPassword,
            name = name,
            role = role
        )
        return memberRepository.save(member)
    }

    fun findByEmail(email: String) = memberRepository.findByEmail(email)}