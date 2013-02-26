package com.udith.mycontacts.validators;

import com.udith.mycontacts.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("contactFormValidator")
public class ContactFormValidator implements Validator {

  @Override
  public boolean supports(Class<?> type) {
    return User.class.isAssignableFrom(type);
  }

  @Override
  public void validate(Object o, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name","required.user_name", "User's Name is required.");
  }

  public void validateEditUserForm(Object o, Errors errors){
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name","required.user_name", "User's Name is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "friend_type", "required.friend_type", "Describe your friendship");
  }

}
