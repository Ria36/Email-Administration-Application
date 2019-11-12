package emailapp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailBoxCapacity = 500;
	private String email;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix = "rias.com";
	
	//Constructor to receive the firstName & lastName
	public Email(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email Created : "+this.firstName + " " +this.lastName);
		
		//Call a method asking for the department - return the department
		this.department = setDepartment();
		//System.out.println("Department : "+this.department);
		
		//Call a method that returns a random Password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email is "+email);
	}
	//Ask for the department
	private String setDepartment() {
		System.out.println("New Worker: " +firstName+". Department Codes\n1 for Sales\n2 for Developement\n3 for Accounting\n0 for none\n Enter the department: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice==1) {
			return "Sales";
		}
		else if(depChoice==2) {
			return "Dev";
		}
		else if(depChoice==3) {
			return "acc";
		}
		else
		{
			return "";
		}
	}
	
		private String randomPassword(int length) {
			
			String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
			char[] password = new char[length];
				for(int i=0;i<length;i++) {
				int randomNuber =(int) (Math.random() * passwordSet.length());
				password[i] = passwordSet.charAt(randomNuber);
				}
			return new String(password);
			
		}
	
	//Set the mailbox capacity
		public void setMailboxCapacity(int capacity) {
			this.mailBoxCapacity = capacity;
		}
	//Set the alternate email
		public void setAlternateEmail(String altemail) {
			this.alternateEmail = altemail;
		}
	//Generate the random password
		public void changePassword(String password) {
			this.password = password;
		}
		
		public int getMailboxCapacity() {
			return mailBoxCapacity;
		}
		public String getAlternateEmail() {
			return alternateEmail;
		}
		public String getPassword() {
			return password;
		}
		
		public String showInfo() {
			return "DISPLAY NAME : "+ firstName + " " + lastName +" " +
					"\nCOMPANY EMAIL : "+ email +
					"\nMAILBOX CAPACITY : "+ mailBoxCapacity + "mb" ;
		}
}
