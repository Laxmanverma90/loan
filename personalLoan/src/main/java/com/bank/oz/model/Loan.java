package com.bank.oz.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author laxman
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "oz_loan")
public class Loan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id", length=6)
	private int loanId;
	private Date applyDate;
	private Date approvalDate;
	private double loanAmount;
	private int installment;
	
	@Column(name = "status", length=10)
	private String status;
	
	@Column(name = "delete_flag", length=1)
	private int deleteFlag;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "custId")
	private Customer customer;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "empId")
	private BankEmployee bankEmployee;
	

	/*@OneToOne
	@JoinColumn(name = "customer_id")
	Customers customers;*/

	@JsonIgnore
	@OneToMany(mappedBy = "loan")
	List<LoanEmi> emi;

	/*@ManyToOne
	@JoinColumn(name = "loanApproverManagerId")
	private BankingPersonnels bankingPersonnel;*/
}
