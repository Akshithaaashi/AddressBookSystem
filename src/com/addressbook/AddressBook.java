package com.addressbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    Scanner userInputs = new Scanner(System.in);

    String email;
    String fName, lName, address, city, state;
    Long zipCode, phoneNum;

    public void setContactsDetails() {
        System.out.println("Enter your First name: ");
        this.fName = userInputs.nextLine();
        System.out.println("Enter your Last name: ");
        this.lName = userInputs.nextLine();
        System.out.println("Enter your Address: ");
        this.address = userInputs.nextLine();
        System.out.println("Enter your City name: ");
        this.city = userInputs.nextLine();
        System.out.println("Enter your State name: ");
        this.state = userInputs.nextLine();
        System.out.println("Enter your Pin Code: ");
        this.zipCode = userInputs.nextLong();
        System.out.println("Enter your Phone Number: ");
        this.phoneNum = userInputs.nextLong();
        System.out.println("Enter your Email ID: ");
        this.email = userInputs.nextLine();
    }

    // to read data from contacts
    public String showContactsDetails() {
        return ("------------------------\nFirst Name: " + fName + "\nLast Name: " + lName + "\nAddress: " + address
                + "\nCity: " + city + "\nState: " + state + "\nPin Code: " + zipCode + "\nPhone Number: " + phoneNum
                + "\nEmail ID: " + email + "\n-------------------------");
    }

    // get complete details of person

    public String getFirstName() {
        return fName;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book");

        List<AddressBook> persons = new ArrayList<>();

        Scanner uc = new Scanner(System.in);
        System.out.println("If you want to add address enter '0' ");
        int userChoice = uc.nextInt();

        if (userChoice == 0) {
            System.out.println("Adding a new Address");

            Scanner n = new Scanner(System.in);
            System.out.println("How many contacts do you want to add to address book: ");
            int noOfPersons = n.nextInt();

            for (int i = 0; i < noOfPersons; i++) {
                AddressBook contact = new AddressBook();
                contact.setContactsDetails();
                persons.add(contact);
                System.out.println(contact.showContactsDetails());
            }

            System.out.println(persons);

            Scanner new1 = new Scanner(System.in);
            System.out.println("Do you want you edit the contacts /nIf 'YES' Enter : '0' /nIf 'NO' Enter : '1'--->: ");
            int userChoice2 = new1.nextInt();

            if (userChoice2 == 0) {

                System.out.println("Editing a contact");

                System.out.println(persons);
                System.out.println("Which contact do you want to edit from address book: ");
                Scanner input = new Scanner(System.in);
                String editContact = input.next();

                for (AddressBook i : persons) {

                    if (i.getFirstName().equals(editContact)) {

                        System.out.println("Change the First Name: ");
                        String editfName = input.next();
                        i.fName = editfName;

                        System.out.println("Change the Last Name: ");
                        String editlName = input.next();
                        i.lName = editlName;

                        System.out.println("Change the Address: ");
                        String editAddress = input.next();
                        i.address = editAddress;

                        System.out.println("Change the City: ");
                        String editCity = input.next();
                        i.city = editCity;

                        System.out.println("Change the State: ");
                        String editState = input.next();
                        i.state = editState;

                        System.out.println("Change the Pin Code: ");
                        Long editZipCode = input.nextLong();
                        i.zipCode = editZipCode;

                        System.out.println("Change the Phone Number: ");
                        Long editPhoneNum = input.nextLong();
                        i.phoneNum = editPhoneNum;

                        System.out.println("Change the Email ID: ");
                        String editEmail = input.next();
                        i.email = editEmail;
                    }
                    System.out.println(persons);

                }
            } else {
                System.out.println("Invalid Option");
            }
        }
    }

}