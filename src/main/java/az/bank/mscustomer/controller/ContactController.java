package az.bank.mscustomer.controller;

import az.bank.mscustomer.service.ContactService;
import az.bank.mscustomer.service.dto.ContactCreateDto;
import az.bank.mscustomer.service.dto.ContactDto;
import az.bank.mscustomer.service.dto.ContactUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> getContact(@PathVariable("id") Long id){
       return new ResponseEntity<>( contactService.getContact(id),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<ContactDto> createCustomer(@RequestBody ContactCreateDto createDto) {
        return new ResponseEntity<>(contactService.createCustomer(createDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> editContact(@PathVariable("id") Long id,
                                                  @RequestBody ContactUpdateDto contactUpdateDto){
        return  new ResponseEntity<>(contactService.editContact(id,contactUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id") Long id){
        contactService.deleteContact(id);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
