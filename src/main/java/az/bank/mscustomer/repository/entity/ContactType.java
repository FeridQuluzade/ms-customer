package az.bank.mscustomer.repository.entity;


import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactType {
  EMAIL,PHONE,EMAIL2;

  @JsonValue
  public String toLower() {
    return this.toString().toLowerCase();
  }
}
