package easypc.frontend.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import easypc.backend.dto.Products;

public class ProdValidator implements Validator {

	@Override
	public boolean supports(Class<?> defaultClass) {

		return Products.class.equals(defaultClass);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Products prod = (Products) target;

		// checking if any file is selected
		if (prod.getFile() == null || prod.getFile().getOriginalFilename().equals("")) {

			errors.rejectValue("file", null, "Please select an Image file to upload");
			return;
		}

		// checking for only imgage files
		if (!(prod.getFile().getContentType().equals("image/jpeg")
				|| prod.getFile().getContentType().equals("image/png")
				|| prod.getFile().getContentType().equals("image/gif"))) {
			
			errors.rejectValue("file", null, "Please Use only Image files to upload");
			return;
			
		}
	}

}
