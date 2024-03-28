package com.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.model.RegistrationBean;

import java.util.regex.Pattern;

public class CustomValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return RegistrationBean.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        RegistrationBean registrationBean = (RegistrationBean) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName", "User Name cannot be blank");

        if (registrationBean.getContactNumber() != 0 && String.valueOf(registrationBean.getContactNumber()).length() != 10) {
            errors.rejectValue("contactNumber", "error.contactNumber", "Contact Number must be 10 digits/Contact Number should not be blank");
        }

        if (registrationBean.getEmailId() == null || registrationBean.getEmailId().isEmpty()) {
            errors.rejectValue("emailId", "error.emailId", "Email ID cannot be blank ");
        } else if (!isValidEmail(registrationBean.getEmailId())) {
            errors.rejectValue("emailId", "error.emailId.format", "Should be a proper email ID format");
        }

        if (registrationBean.getConfirmEmailId() == null || registrationBean.getConfirmEmailId().isEmpty()) {
            errors.rejectValue("confirmEmailId", "error.confirmEmailId", "Confirm Email ID cannot be blank ");
        } else if (!isValidEmail(registrationBean.getConfirmEmailId())) {
            errors.rejectValue("confirmEmailId", "error.confirmEmailId.format", "Should be a proper email ID format");
        }

        if (!registrationBean.getEmailId().equals(registrationBean.getConfirmEmailId())) {
            errors.rejectValue("confirmEmailId", "error.confirmEmailId", "Email and Confirm Email should be same");
        }

        if (!registrationBean.isStatus()) {
            errors.rejectValue("status", "error.status", "please agree to terms and conditions.");
        }
    }

    private boolean isValidEmail(String email) {
        // Regular expression for basic email format validation
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.matches(emailPattern, email);
    }
}
