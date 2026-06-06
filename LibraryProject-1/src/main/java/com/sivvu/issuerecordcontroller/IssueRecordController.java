package com.sivvu.issuerecordcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivvu.issuerecordservice.IssueRecordService;

@RestController
@RequestMapping

public class IssueRecordController {
	private IssueRecordService service;
	public IssueRecordController(IssueRecordService service) {
		this.service=service;
	}
	
@PostMapping("/issuebook")
public String issuebook(@RequestParam String bookTitle,@RequestParam String bookAuthor) {
	return service.issuebook(bookTitle,bookAuthor);
	
}
@PostMapping("/returnbook")
public String returnbook(@RequestParam String bookTitle,@RequestParam String bookAuthor) {
       return service.returnbook(bookTitle,bookAuthor);
}
}