package com.addressbook;
import java.util.*;

class AddressBookMain {
    public static Scanner sc = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();
    private String addressBookName;

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
                    +"5]Exit\n"
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

                case 4:{
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addressBookMain.searchPersonByState(StateName);
                    break;
                }

                case 5:
                    flag = false;
                    break;
            }
        }
    }
    private void searchPersonByState(String stateName) {
        // TODO Auto-generated method stub
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }
    private void searchPersonByCity(String cityName) {
        // TODO Auto-generated method stub
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }
}