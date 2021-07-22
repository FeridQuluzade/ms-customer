package az.bank.mscustomer.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String message) {
        super(message);
    }
}
