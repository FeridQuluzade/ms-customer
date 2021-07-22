package az.bank.mscustomer.exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String message) {
        super(message);
    }
}
