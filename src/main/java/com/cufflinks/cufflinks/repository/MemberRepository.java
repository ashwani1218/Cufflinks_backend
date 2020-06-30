/**
 * 
 */
package com.cufflinks.cufflinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cufflinks.cufflinks.entity.Member;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
public interface MemberRepository extends JpaRepository<Member, Long> {

}
