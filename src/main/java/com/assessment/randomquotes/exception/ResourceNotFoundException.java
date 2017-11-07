/**
 * 
 */
package com.assessment.randomquotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mterraciano
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This resource is not found in the system")
public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 100L;

}