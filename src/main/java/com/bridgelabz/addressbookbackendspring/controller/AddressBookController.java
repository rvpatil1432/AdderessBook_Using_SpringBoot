package com.bridgelabz.addressbookbackendspring.controller;

import com.bridgelabz.addressbookbackendspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookbackendspring.dto.ResponseDTO;
import com.bridgelabz.addressbookbackendspring.model.AddressBookData;
import com.bridgelabz.addressbookbackendspring.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /*
     * Purpose: To get all the contact details from the address book
     * @return returns ResponseEntity which is holding ResponseDTO and HttpStatus
     * */
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> contactList = null;
        contactList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * Purpose: To get the contact details from the address book using its personId
     * @return returns ResponseEntity which is holding ResponseDTO and HttpStatus
     * */
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId") int personId) {
        AddressBookData personData = null;
        personData = addressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", personData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * Purpose: To add new contact details to the address book
     * @return returns ResponseEntity which is holding ResponseDTO and HttpStatus
     * */
    @PostMapping("/addnewcontact")
    public ResponseEntity<ResponseDTO> addNewContact(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData personData = null;
        personData = addressBookService.addNewContact(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("New Contact Added Sucessfully", personData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * Purpose: To update existing contact details to the address book
     * @return returns ResponseEntity which is holding ResponseDTO and HttpStatus
     * */
    @PutMapping("/updatecontact")
    public ResponseEntity<ResponseDTO> updateContact(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData personData = null;
        personData = addressBookService.updateContact(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Updated Sucessfully", personData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * Purpose: To delete the contact details by Id to the address book
     * @return returns ResponseEntity which is holding ResponseDTO and HttpStatus
     * */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("personId") int personId) {
        addressBookService.deleteContact(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Contact Sucessfully", "Deleted Id: "+ personId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
