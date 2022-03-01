package com.bridgelabz.addressbookbackendspring.service;

import com.bridgelabz.addressbookbackendspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookbackendspring.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    private List<AddressBookData> contactList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> contactList = new ArrayList<>();
        contactList.add(new AddressBookData(1, new AddressBookDTO("Rohini",
                "Patil", "Pune", "9689803665")));
        return contactList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        AddressBookData contact = null;
        contact = new AddressBookData(1, new AddressBookDTO("Vishal",
                "Patil", "Mumbai", "7658580923"));
        return contact;
    }

    @Override
    public AddressBookData addNewContact(AddressBookDTO addressBookDTO) {
        AddressBookData contact = null;
        contact = new AddressBookData(1, addressBookDTO);
        return contact;
    }

    @Override
    public AddressBookData updateContact(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData contact = this.getAddressBookDataById(personId);
        contact.setFirstName(addressBookDTO.firstName);
        contact.setLastName(addressBookDTO.lastName);
        contact.setAddress(addressBookDTO.address);
        contact.setAddress(addressBookDTO.mobileNo);
        contactList.set(personId-1, contact);
        return contact;
    }

    @Override
    public void deleteContact(int personId) {

    }
}
