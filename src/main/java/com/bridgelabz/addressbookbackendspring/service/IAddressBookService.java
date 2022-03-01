package com.bridgelabz.addressbookbackendspring.service;

import com.bridgelabz.addressbookbackendspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookbackendspring.model.AddressBookData;


import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData addNewContact(AddressBookDTO addressBookDTO);

    AddressBookData updateContact(int personId, AddressBookDTO addressBookDTO);

    void deleteContact(int personId);
}