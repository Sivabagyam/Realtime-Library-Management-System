package com.sivvu.membercontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivvu.membermodel.Member;
import com.sivvu.memberservice.MemberService;
@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/member")
public class MemberController {
	private MemberService service;
	public MemberController(MemberService service) {
		this.service=service;
	}
	
	
	@PostMapping("/addmembers") 
	public Member addMembers(@RequestBody Member mem) {
		return service.addMembers(mem);
	}
	@PostMapping("/verifymembers")
	public String verifyMembers(@RequestParam String memberEmail,@RequestParam String memberPassword) {
		return service.verifyMembers(memberEmail,memberPassword);
	}

}
