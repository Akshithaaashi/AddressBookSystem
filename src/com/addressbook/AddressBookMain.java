package com.addressbook;
import java.util.*;

class AddressBookMain {
    public static Scanner sc = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();
    private String addressBookName;

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book  System ");
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean flag =true;
        while(flag)
        {
            System.out.println("Select an option\n"
                    +"1] Add New Address Book\n"
                    +"2] Find Duplicate Entry in Address Book\n"
                    +"3]Search Contact from a city\n"
                    +"4]Search Contact from a State\n"
                    +"5]View contact By State Using State and Person\n"
                    +"6]View Contact by city Using City and Person \n"
                    +"7]Display AddressBook\n"
                    +"8]Count  By State\n"
                    +"9]Count  By city\n"
                    +"10]Exit\n"
                    + "Enter your Choice\n");
            int option = sc.nextInt();
            switch (option){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    if(addressBookMain.addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address book Already Exists");
                        break;
                    }else {
                        addressBookMain.addAddressBook(addressBookName);
                        break;
                    }
                }
                case 2:
                    for (Map.Entry<String, AddressBook> entry : addressBookMain.addressBookListMap.entrySet()) {
                        AddressBook value = entry.getValue();
                        System.out.println("Address Book Name: " + entry.getKey());
                        value.checkDuplicate();
                    }
                case 3:
                    System.out.println("Enter Name of City: ");
                    String CityName = sc.next();
                    addressBookMain.searchPersonByCity(CityName);
                    break;

                case 4:
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addressBookMain.searchPersonByState(StateName);
                    break;


                case 5:
                    System.out.println("Enter Name of State: ");
                    String state = sc.next();
                    addressBookMain.viewPersonByState(state);
                    break;

                case 6:
                    System.out.println("Enter Name of City: ");
                    String city = sc.next();
                    addressBookMain.viewPersonByCity(city);
                    break;


                case 7:
                    System.out.println("Enter the Person First name to Display ");
                    String Name = sc.next();

                    boolean list = addressBook.DisplayAddressBook(Name);
                    if (list) {
                        System.out.println("Displayed the Address Book");
                    } else {
                        System.out.println(" Cannot be Displayed");
                    }

                    break;
                case 8:
                    System.out.println("Enter  State Name: ");
                    String stateName = sc.next();
                    addressBookMain.NoofPeoplefromParticulerState(stateName);
                    break;

                case 9:
                    System.out.println("Enter  City Name: ");
                    String cityName = sc.next();
                    addressBookMain.NoofPeoplefromParticulercity(cityName);
                    break;

                case 10:
                    flag = false;
                    break;
            }
        }
    }

    // Add Address Book
    public void addAddressBook(String bookName){


        boolean flag = true;

        while(flag) {
            System.out.println("Select an option to select\n"
                    +"1] Add Contact\n"
                    +"2] Display\n"
                    +"3] Edit contact\n"
                    +"4] Delete Contact\n"
                    +"5] Exit\n"
                    + "Enter your Choice\n");
            int option = sc.nextInt();

            switch (option)
            {
                case 1:

                    System.out.println("enter no of contacts to be added");
                    int noOfContacts = sc.nextInt();
                    for(int i = 0; i < noOfContacts; i++) {
                        addressBook.addContactDetails();
                    }
                    addressBookListMap.put(addressBookName, addressBook);
                    System.out.println("Address Book Added Successfully");
                    break;

                case 2:
                    System.out.println("Enter the Person First name to Display ");
                    String Name = sc.next();

                    boolean list = addressBook.Display(Name);
                    if (list) {
                        System.out.println("Displayed the Contact");
                    } else {
                        System.out.println(" Cannot be Displayed");
                    }

                    break;

                case 3:
                    System.out.println("Enter the Person First name to edit details: ");
                    String personName = sc.next();

                    boolean listEdited = addressBook.editContactDetails(personName);
                    if (listEdited) {
                        System.out.println("List Edited Successfully");
                    } else {
                        System.out.println("List Cannot be Edited");
                    }

                    break;
                case 4:
                    System.out.println("Enter the Contact to be deleted:");
                    String firstName = sc.next();
                    boolean listDeleted = addressBook.deleteContact(firstName);
                    if (listDeleted) {
                        System.out.println("Deleted Contact from the List");
                    } else {
                        System.out.println("List Cannot be Deleted");
                    }
                    break;
                case 5:
                    flag =false;
                    break;


            }


        }

    }

    // Search Person by State
    private void searchPersonByState(String stateName) {
        // TODO Auto-generated method stub
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(stateName);
        }

    }

    // Search Person by city
    private void searchPersonByCity(String cityName) {
        // TODO Auto-generated method stub
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByCity(cityName);
        }

    }

    // view Person by State

    private void viewPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactDetails> contacts = value.personByState.entrySet().stream().filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(ContactDetails contact: contacts){
                System.out.println("First Name: "+contact.getFirstName()+" Last Name: "+ contact.getLastName());
            }
        }
    }
    // view Person by city
    private void viewPersonByCity(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactDetails> contacts = value.personByCity.entrySet().stream().filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(ContactDetails contact: contacts){
                System.out.println("First Name: "+contact.getFirstName()+" Last Name: "+ contact.getLastName());
            }
        }
    }

//	  Count contact persons from particular state

    public void NoofPeoplefromParticulerState(String state) {
        int count = 0;
        for(Map.Entry<String, AddressBook> entry: addressBookListMap.entrySet()){
            for(int i=0;i<(entry.getValue()).contactList.size();i++)
            {
                ContactDetails contact= entry.getValue().contactList.get(i);

                if(state.equals(contact.getState()))
                {
                    count++;
                }

            }
        }
        System.out.println("Total Person from the state "+state+": "+count);
    }

    // Count contact persons from particular city
    public void NoofPeoplefromParticulercity(String city) {
        int countPersonInCity=0;
        for(Map.Entry<String, AddressBook> entry: addressBookListMap.entrySet())
        {
            for(int i=0;i<(entry.getValue()).contactList.size();i++)
            {
                ContactDetails d= (ContactDetails) entry.getValue().contactList.get(i);

                if(city.equals(d.getCity()))
                {
                    countPersonInCity++;
                }
            }
        }
        System.out.println("Total persons from this city "+city+": "+countPersonInCity);
    }
}