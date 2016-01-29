package edu.neu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.neu.model.VitalSigns;

@Component
public class VitalSignsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return VitalSigns.class.equals(clazz);
		}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		VitalSigns vitalSigns  = (VitalSigns) target;
		System.out.println("in vitalSign validator");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"bodytemperature","bodytemperature", "Enter BodyTemperature");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodpressure","bloodpressure", "Enter BloodPressure");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pulserate", "pulserate","Enter PulseRate");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "respiratoryrate", "respiratoryrate","Enter RespiratoryRate");
		if(vitalSigns.getBodytemperature()<0 || vitalSigns.getBodytemperature()>110)
		errors.rejectValue("bodytemperature", "validate.bodytemperature","Invalid bodytemperature");
		if(vitalSigns.getBloodpressure()<0 || vitalSigns.getBloodpressure()>220)
			errors.rejectValue("bloodpressure", "validate.bloodpressure", "Invalid bloodpressure");
		if(vitalSigns.getPulserate()<0 || vitalSigns.getPulserate()>100)
			errors.rejectValue("pulserate", "validate.pulserate", "Invalid bloodpressure");
		if(vitalSigns.getRespiratoryrate()<0 || vitalSigns.getRespiratoryrate()>80)
			errors.rejectValue("respiratoryrate", "validate.respiratoryrate","Invalid respiratory rate");
			
		
	
	}

}
