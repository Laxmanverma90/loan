package com.bank.oz.bean;

import java.io.Serializable;
import java.util.Date;

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
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int custId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String orgnisation;
	private int expInMonths;
	private int score;
	private String address;
}
