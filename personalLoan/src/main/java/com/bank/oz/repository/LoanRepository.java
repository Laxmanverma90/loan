package com.bank.oz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.oz.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, java.lang.Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE oz_loan lo set lo.delete_flag=1 where lo.loan_id= :loanId and lo.status= :status",nativeQuery = true)
	public int updateByLoanIdAndStatus(@Param(value = "loanId") int loanId, @Param(value = "status") String status);
	
	public List<Loan> findByStatus(String status);
	
	public Loan findByLoanId(int loanId);
}
