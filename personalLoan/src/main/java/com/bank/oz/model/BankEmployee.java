package com.bank.oz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @author Laxman
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "oz_employee")
public class BankEmployee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id", length=6)
	private int empId;
	
	@Column(name = "first_name", length=10)
	private String firstName;
	
	@Column(name = "last_name", length=10)
	private String lastName;
	
	@Column(name = "desigination", length=10)
	private String desigination;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bankEmployee", cascade = CascadeType.ALL)
	private List<Loan> loan;
}
