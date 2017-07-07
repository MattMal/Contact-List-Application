# Contact-List-Application

import java.util.Scanner;

public class Main {
	
	static boolean run = true;
	static String option = "0";
	static Scanner scan = new Scanner(System.in);
	static ContactHolder ch = new ContactHolder();
	

	public static void main(String[] args) {

		while(run == true){
			System.out.println("\n1. to Quit the program");
			System.out.println("2. to Add New Contact");
			System.out.println("3. to Print the Contact List");
			System.out.println("4. To Modify a contact");
			System.out.println("5. To Remove a contact");

			option = scan.next();
			switch(option){
			case "1":
				quit();
				break;
			case "2":
				addNewContact();
				break;
			case "3":
				printContactList();
				break;
			case "4":
				updateContact();
				break;
			case "5":
				removeContact();
				break;
			default:
				System.out.println("Please choose a valid option");
			}
			
			
		}
		
	}
	
	public static void quit(){
		System.out.println("The program has been quit");
		run = false;
	}
	
	public static void addNewContact(){		
		ch.addContact(new Contacts());
	}
	
	public static void printContactList(){
		ch.printAllContacts();
	}
	
	public static void updateContact(){
		System.out.println("Please enter name of contact you want to modify");
		ch.modify(scan.next());
	}
	
	public static void removeContact(){
		System.out.println("Please enter name on file you want to remove");
		ch.remove(scan.next());
	}
	
	public static void searchContact(){
		System.out.println("Please enter name on file you want to remove");

	}
	
	

}

import java.util.ArrayList;
import java.util.Scanner;

public class ContactHolder {
	ArrayList<Contacts> list = new ArrayList<Contacts>();
	Scanner scanner = new Scanner(System.in);

	public void addContact(Contacts contactIn) {
		for (int i = 0; i < list.size(); i++) {
			if (contactIn.getName().equalsIgnoreCase(list.get(i).getName())
					|| contactIn.getNumber().equalsIgnoreCase(list.get(i).getNumber())) {
				System.out.println("The contact Name or Number already exists");

				return;

			}

		}
		list.add(contactIn);

		System.out.println("Contact added was " + contactIn.getName() + " and the number was " + contactIn.getNumber());

	}

	public String querry(Contacts contactIn) {
		for (int i = 0; i < list.size(); i++) {
			if (contactIn.getName().equalsIgnoreCase(list.get(i).getName())
					|| contactIn.getNumber().equalsIgnoreCase(list.get(i).getNumber())) {
				return list.get(i).getNumber();

			}

		}
		return "Contact does not exist";
	}

	// public void modify(Contacts contactIn) {
	// boolean duplicate = list.contains(contactIn);
	// if (duplicate == true) {
	// String addName = scanner.next();
	// contactIn.setName(addName);
	// String addNum = scanner.next();
	// contactIn.setNumber(addNum);
	// } else {
	// System.out.println("Contact does not exist");
	// }
	// }

	public void modify(String nameIn) {
		for (int i = 0; i < list.size(); i++) {
			if (nameIn.equalsIgnoreCase(list.get(i).getName())) {

				System.out.println("Please enter new NAME: ");
				list.get(i).setName(scanner.next());
				System.out.println("Please enter new NUMBER: ");
				list.get(i).setNumber(scanner.next());

				return;
			}

		}
		System.out.println("There is no contact with that name");
	}

	public void remove(String nameIn) {
		for (int i = 0; i < list.size(); i++) {
			if (nameIn.equalsIgnoreCase(list.get(i).getName())) {
				list.remove(i);
				System.out.println(nameIn + " has been removed from contact list");
				return;
			}
		}
		System.out.println("The contact does not exist, so there was no removal");
	}

	// public void remove(Contacts contactIn) {
	// boolean duplicate = list.contains(contactIn);
	// if (duplicate == false) {
	// list.remove(contactIn);
	// } else {
	// System.out.println("Contact does not exist");
	// }
	//
	// }

	// @Override
	// public String toString() {
	// return "ContactHolder [list=" + list + ", scanner=" + scanner + "]";
	// }

	public void printAllContacts() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\nName:" + list.get(i).getName());
			System.out.println("Number:" + list.get(i).getNumber());
		}
	}

}

import java.util.Scanner;

public class Contacts {
	
	String name;
	String number;
	Scanner scanNew = new Scanner(System.in);
	public Contacts() {
		System.out.println("Enter Name: \r");
		this.name = scanNew.next();
		System.out.println("Enter Phone number: \r");
		this.number = scanNew.next();
	}
	
	public String toString() {
		return "Contacts [name=" + name + ", number=" + number + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	
}



