/**
 * 
 */
package com.assessment.randomquotes.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mterraciano
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This resource is not found in the system")
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2581975292273282583L;

	final String errorMessage;

	final String errorCode;

	public ResourceNotFoundException(String errorMessage, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

}