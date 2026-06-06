package com.sivvu.issuerecordrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivvu.bookmodel.Book;
import com.sivvu.issuerecordmodel.IssueRecordModel;
@Repository
public interface IssueRecordRepository  extends JpaRepository<IssueRecordModel,String> {

	

}
