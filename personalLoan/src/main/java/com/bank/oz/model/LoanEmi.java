package com.bank.oz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "oz_loanemi")
public class LoanEmi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emi_id", length=6)
	private Long emiId;
	
	private double monthylyEmi;
	private double pendingAmount;
	
	@Temporal(TemporalType.DATE)
	private Date emiPaymentDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="loan_Id")
	Loan loan;

}
