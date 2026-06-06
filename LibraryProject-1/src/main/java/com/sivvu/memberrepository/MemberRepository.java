package com.sivvu.memberrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sivvu.membermodel.Member;
@Repository
public interface MemberRepository extends JpaRepository <Member,Integer>{

	Member findByMemberEmailAndMemberPassword(String memberEmail, String memberPassword);

	Member findMemberByMemberName(String memberName);
     
	

}
