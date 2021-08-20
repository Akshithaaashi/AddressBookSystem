package com.addressbook;
import java.util.*;

/*
 * This code takes input from console as name, address, phone number, email and prints address book.
 * also includes feature of adding multiple address books.
 */

class AddressBookMain {
    public static Scanner sc = new Scanner(System.in);
    private static ContactFunctions contactFunctions = new ContactFunctions();
    public Map<String, ContactFunctions> addressBookListMap = new HashMap<>();
    private String addressBookName;

    //Add new AddressBook
    public void addAddressBook(String bookName) {

        boolean flag = true;

        while (flag) {
            System.out.println("1] Add Contact\n" + "2] Display\n"
                    + "3] Edit contact\n" + "4] Delete Contact\n" + "5] Exit\n" + "Enter your Choice\n");
            int option = sc.nextInt();

            switch (option) {
                case 1:

                    System.out.println("enter no of contacts to be added");
                    int noOfContacts = sc.nextInt();
                    for (int i = 0; i < noOfContacts; i++) {
                        contactFunctions.addContactDetails();
                    }
                    addressBookListMap.put(addressBookName, contactFunctions);
                    System.out.println("Address Book Added Successfully");
                    break;

                case 2:
                    System.out.println("Enter the Person First name to Display ");
                    String Name = sc.next();

                    boolean list = contactFunctions.Display(Name);
                    if (list) {
                        System.out.println("Displayed the Contact");
                    } else {
                        System.out.println(" Cannot be Displayed");
                    }

                    break;

                case 3:
                    System.out.println("Enter the Person First name to edit details: ");
                    String personName = sc.next();

                    boolean listEdited = contactFunctions.editContactDetails(personName);
                    if (listEdited) {
                        System.out.println("List Edited Successfully");
                    } else {
                        System.out.println("List Cannot be Edited");
                    }

                    break;
                case 4:
                    System.out.println("Enter the Contact to be deleted:");
                    String firstName = sc.next();
                    boolean listDeleted = contactFunctions.deleteContact(firstName);
                    if (listDeleted) {
                        System.out.println("Deleted Contact from the List");
                    } else {
                        System.out.println("List Cannot be Deleted");
                    }
                    break;
                case 5:
                    flag = false;
                    break;

            }

        }

    }

    //main method
    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean flag = true;
        while (flag) {
            System.out.println("Enter your choice");
            System.out.println("Select an option\n" + "1] Add New Address Book\n"
                    + "2] Find Duplicate Entry in Address Book\n" + "3]Search Contact from a city\n"
                    + "4]Search Contact from a State\n" + "5]Exit\n" + "Enter your Choice\n");
            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    if (addressBookMain.addressBookListMap.containsKey(addressBookName)) {
                        System.out.println("The Address book Already Exists");
                        break;
                    } else {
                        addressBookMain.addAddressBook(addressBookName);
                        break;
                    }
                }
                case 2:
                    for (Map.Entry<String, ContactFunctions> entry : addressBookMain.addressBookListMap.entrySet()) {
                        ContactFunctions value = entry.getValue();
                        System.out.println("Address Book Name: " + entry.getKey());
                        value.checkDuplicate();
                    }
            }
        }

    }
}