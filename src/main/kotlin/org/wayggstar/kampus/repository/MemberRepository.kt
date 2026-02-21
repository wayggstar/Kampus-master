package org.wayggstar.kampus.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.wayggstar.kampus.entity.Member

@Repository
interface MemberRepository: JpaRepository<Member, Long> {

    fun findByEmail(email: String): Member
}