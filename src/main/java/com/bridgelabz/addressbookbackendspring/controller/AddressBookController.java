package com.bridgelabz.addressbookbackendspring.controller;

import com.bridgelabz.addressbookbackendspring.dto.AddressBookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
    /*
     * Purpose: To get all the contact details from the address book
     * @return returns ResponseEntity which is holding success message and HttpStatus
     * */
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    /*
     * Purpose: To get the contact details from the address book using its personId
     * @return returns ResponseEntity which is holding success message and HttpStatus
     * */
    @GetMapping("/get/{personId}")
    public ResponseEntity<String> getAddressBookData(@PathVariable("personId") int personId) {
        return new ResponseEntity<String>("Get Call Success for id: "+ personId, HttpStatus.OK);
    }

    /*
     * Purpose: To add new contact details to the address book
     * @return returns ResponseEntity which is holding success message and HttpStatus
     * */
    @PostMapping("/addnewcontact")
    public ResponseEntity<String> addNewContact(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<String>("Created New Contact for: "+ addressBookDTO, HttpStatus.OK);
    }

    /*
     * Purpose: To update existing contact details to the address book
     * @return returns ResponseEntity which is holding success message and HttpStatus
     * */
    @PutMapping("/updatecontact")
    public ResponseEntity<String> updateContact(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<String>("Updated Contact : "+ addressBookDTO, HttpStatus.OK);
    }

    /*
     * Purpose: To update existing contact details to the address book
     * @return returns ResponseEntity which is holding success message and HttpStatus
     * */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteContact(@PathVariable("personId") int personId) {
        return new ResponseEntity<String>("Delete Call Success for id: " +personId, HttpStatus.OK);

    }

}
