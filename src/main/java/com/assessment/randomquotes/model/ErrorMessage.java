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
