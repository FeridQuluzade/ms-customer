package az.bank.mscustomer.model.exception;

public class CustomerNotFoundException extends NotFoundException{

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
