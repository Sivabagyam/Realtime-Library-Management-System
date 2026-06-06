package com.sivvu.issuerecordmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class IssueRecordModel {
	@Id
	private String bookName;
	private String bookAuthor;
	
	

}
