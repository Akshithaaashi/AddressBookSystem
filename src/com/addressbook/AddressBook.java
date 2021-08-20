package com.addressbook;


import java.util.*;
import java.util.stream.Collectors;


public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public ArrayList<ContactDetails> contactList = new ArrayList<>();
    // Add Contact Details
    public void addContactDetails(){
        System.out.println("Enter the contact details:");
        System.out.println("Enter First Name");
        String firstName = sc.next();
        System.out.println("Enter last Name");
        String lastName = sc.next();
        System.out.println("Enter Address ");
        String address = sc.next();
        System.out.println("Enter City ");
        String city = sc.next();
        System.out.println("Enter State ");
        String state = sc.next();
        System.out.println("Enter  Email ");
        String email = sc.next();
        System.out.println("Enter phone Number");
        String phoneNumber = sc.next();
        System.out.println("Enter Zip code");
        String zip = sc.next();

        ContactDetails contactDetails = new ContactDetails(firstName, lastName, address, city, state, email, phoneNumber, zip);
        contactList.add(contactDetails);
        System.out.println(contactDetails);

    }
    // Edit Contact Details
    public boolean editContactDetails(String Name)
    {
        int flag = 0;
        for(ContactDetails contact: contactList)
        {
            if(contact.getFirstName().equals(Name))
            {

                System.out.println("Select an option to edit\n"
                        +"1] First Name\n"
                        +"2] Last Name\n"
                        +"3] Address\n"
                        +"4] City\n"
                        +"5] State\n"
                        +"6] Email"
                        +"7] phone Number\n"
                        +"8] ZIP code\n");

                int choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                    {
                        System.out.println("Enter First Name: ");
                        String firstName = sc.next();
                        contact.setFirstName(firstName);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter last name: ");
                        String lastName = sc.next();
                        contact.setLastName(lastName);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter Address: ");
                        String address = sc.next();
                        contact.setAddress(address);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter City: ");
                        String city = sc.next();
                        contact.setCity(city);
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter State: ");
                        String state =sc.next();
                        contact.setState(state);
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Enter Email: ");
                        String email = sc.next();
                        contact.setZip(email);
                        break;
                    }
                    case 7:
                    {
                        System.out.println("Enter Phone Number:");
                        String phoneNumber = sc.next();
                        contact.setPhoneNumber(phoneNumber);
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Enter Zip Code: ");
                        String zip = sc.next();
                        contact.setZip(zip);
                        break;
                    }

                }

                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }
    //	Display Contact
    public boolean Display(String Name)
    {
        int flag = 0;
        for(ContactDetails contact: contactList)
        {
            if(contact.getFirstName().equals(Name))
            {
                System.out.println(contact);
                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }
    // Delete Contact Details
    public boolean deleteContact(String name) {
        int flag = 0;
        for(ContactDetails contact: contactList)
        {
            if(contact.getFirstName().equals(name))
            {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }
    // Check Duplicate Entry
    public void checkDuplicate() {
        Set<String> ContactSet = new HashSet<>();
        Set<ContactDetails> filterSet = contactList.stream().filter(n -> !ContactSet.add(n.getFirstName())).collect(Collectors.toSet());

        for (ContactDetails contact : filterSet) {
            System.out.println("The Duplicate Contact is: " + contact.getFirstName() + " " + contact.getLastName());
        }


    }
    // Get Person Name by State
    public void getPersonNameByState(String State) {
        List<ContactDetails> list  = contactList.stream().filter(p ->p.getState().equals(State)).collect(Collectors.toList());
        for(ContactDetails contact: list){
            System.out.println("First Name: "+contact.getFirstName());
            System.out.println("Last Name: "+contact.getLastName());
        }

    }
    // Get Person Name by city
    public void getPersonNameByCity(String cityName) {
        List<ContactDetails> list  = contactList.stream().filter(p ->p.getCity().equals(cityName)).collect(Collectors.toList());
        for(ContactDetails contact: list){
            System.out.println("First Name: "+contact.getFirstName());
            System.out.println("Last Name: "+contact.getLastName());
        }
    }
}