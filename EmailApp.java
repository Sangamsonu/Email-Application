import java.util.*;

public class EmailApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name :");
        String firstName = sc.nextLine();
        System.out.print("Enter last name :");
        String lastName = sc.nextLine();
		Email em = new Email(firstName,lastName);
		System.out.println(em.showInfo());

	}
}

class Email {

	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 8;
	private String email;
	private String department;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "google.com";
	
	//constructor to receive the first name and last name
	public Email(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		// call a method asking for the department  - return the department 
		this.department = setDepartment();
		
		
		// combine element to generate email
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
		
		
		
		// Call a method that return a random password
		this.password= randomPassword(defaultPasswordLength);
		System.out.println("Your Password is :" +this.password);
		
	}
	
	//Ask for the department name
	private String setDepartment() {
		System.out.println("New Worker: "+ firstName +" .Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department code: ");
		Scanner sc = new Scanner(System.in);
		int deptChoice = sc.nextInt();
		if(deptChoice == 1) {
			return "Sales";
		}else if(deptChoice == 2) {
			return "Development";
		}else if(deptChoice == 3) {
			return "Accounting";
		}else {
			return "N/A";
		}	
	}
	
	//Generate a random password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ01223456789!@#$";
		Random random = new Random();	
		StringBuilder password = new StringBuilder();
		
		for(int i=0; i<length; i++) {
			int rand = random.nextInt(passwordSet.length());
			password.append(passwordSet.charAt(rand));
		}
		return password.toString();
		}

	//Set the mail Box Capacity
	public void setMailboxCapacity(int capacity){
		this.mailBoxCapacity = capacity;
	}
	
	//Set the alternate Email
	public void setAlternateMail(String altEmail){
		this.alternateEmail = altEmail;
	}
	 
	//Change the password
	public void changePassword(String password){
		this.password = password;
	}

	public int getMailboxCapacity(){
		return mailBoxCapacity;
	}
	
	public String getAlternateMail(){
		return alternateEmail;
	}
	
	public String getchangePassword(){
		return password;
	}
	
	public String showInfo() {
		return "Display Name : "+firstName+" "+lastName +
				"\nCompany Email : "+email+
				"\nMailBox Capacity : "+ mailBoxCapacity +"mb";
	}
	
}
