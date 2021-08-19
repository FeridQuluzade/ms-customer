package az.bank.mscustomer.validation;

import az.bank.mscustomer.repository.entity.ContactType;
import az.bank.mscustomer.service.dto.ContactDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ContactsValidator implements ConstraintValidator<ContactsConstraint , ContactType> {

    @Override
    public void initialize(ContactsConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ContactType value, ConstraintValidatorContext context) {
       return !(value==null);
    }
}
