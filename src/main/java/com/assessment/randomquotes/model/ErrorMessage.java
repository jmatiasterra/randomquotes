/**
 * 
 */
package com.assessment.randomquotes.model;

/**
 * @author mterraciano
 *
 */
public class ErrorMessage {

	private String text;
	private String errorCode;
	private String stackTrace;

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the stackTrace
	 */
	public String getStackTrace() {
		return stackTrace;
	}

	/**
	 * @param stackTrace
	 *            the stackTrace to set
	 */
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public ErrorMessage(String text, String errorCode, String stackTrace) {
		super();
		this.text = text;
		this.errorCode = errorCode;
		this.stackTrace = stackTrace;
	}

	/**
	 * 
	 */
	public ErrorMessage() {
		super();
	}

	/**
	 * @param text
	 * @param errorCode
	 */
	public ErrorMessage(String text, String errorCode) {
		super();
		this.text = text;
		this.errorCode = errorCode;
	}

}
