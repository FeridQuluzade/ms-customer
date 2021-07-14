package az.bank.mscustomer.exception;

public class CustomerNotFoundException extends NotFoundException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
