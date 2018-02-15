/**
 * 
 */
package com.assessment.randomquotes.resource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assessment.randomquotes.resource.exception.ResourceNotFoundException;
import com.assessment.randomquotes.resource.model.AuthorDTO;
import com.assessment.randomquotes.resource.model.ErrorMessage;
import com.assessment.randomquotes.resource.model.QuoteDTO;
import com.assessment.randomquotes.resource.services.AuthorService;
import com.assessment.randomquotes.resource.services.QuoteService;

/**
 * @author jm
 *
 */
@Controller
@RequestMapping(value = "/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private QuoteService quoteService;
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<AuthorDTO> getAllAuthors() {
		return authorService.findAllAuthors();
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public AuthorDTO getAuthor(@PathVariable("id") Long id) {
		AuthorDTO author = authorService.findById(id);
		if (author == null) {
			throw new ResourceNotFoundException("Resource Not Found", "404");
		}
		return author;
	}
	
	@PreAuthorize("#oauth2.hasScope('read') and #oauth2.hasScope('write')")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public Long createAuthor(@RequestBody AuthorDTO author) {
		return authorService.createAuthor(author);
	}
	
	@PreAuthorize("#oauth2.hasScope('read') and #oauth2.hasScope('write')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void deleteAuthor(@PathVariable("id") Long id) {
		authorService.deleteAuthorById(id);
	}

	// this could be no content
	@PreAuthorize("#oauth2.hasScope('read') and #oauth2.hasScope('write')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDTO author) {
		AuthorDTO saveAuthor = authorService.findById(id);
		if (saveAuthor != null) {
			author.setId(id);
			authorService.updateAuthor(author);
		} else {
			throw new ResourceNotFoundException("Resource Not Found", "404");
		}
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(value = "/{id}/quotes/", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<QuoteDTO> getQuotesByAuthor(@PathVariable("id") Long id) {
		List<QuoteDTO> quotes = quoteService.findQuotesByAuthorId(id);
		return quotes;
	}
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(value = "/{id}/quotes/{quoteId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public QuoteDTO getQuoteByAuthorById(@PathVariable("id") Long authorId, @PathVariable("quoteId") Long quoteId) {
		AuthorDTO author = authorService.findById(authorId);
		if (author != null) {
			return quoteService.findById(quoteId);
		}
		return null;
	}

	@PreAuthorize("#oauth2.hasScope('read') and #oauth2.hasScope('write')")
	@RequestMapping(value = "/{id}/quotes/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public Long createQuoteForAuthor(@PathVariable("id") Long id, @RequestBody QuoteDTO quote) {
		AuthorDTO author = authorService.findById(id);
		if (author != null) {
			quote.setAuthorId(id);
			return quoteService.createQuote(quote);
		}
		return null;
	}

	// this could be no content
	@PreAuthorize("#oauth2.hasScope('read') and #oauth2.hasScope('write')")
	@RequestMapping(value = "/{id}/quotes/{quoteId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void updateQuoteForAuthor(@PathVariable("id") Long id, @PathVariable("quoteId") Long quoteId,
			@RequestBody QuoteDTO quote) {
		AuthorDTO saveAuthor = authorService.findById(id);
		if (saveAuthor != null) {
			QuoteDTO savedQuote = quoteService.findById(id);
			if (savedQuote != null) {
				quoteService.updateQuote(quoteId, quote);
			}
		}
	}

	@PreAuthorize("#oauth2.hasScope('read') and #oauth2.hasScope('write')")
	@RequestMapping(value = "/{id}/quotes/{quoteId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void deleteQuoteForAuthor(@PathVariable("id") Long id, @PathVariable("quoteId") Long quoteId) {
		AuthorDTO author = authorService.findById(id);
		if (author != null) {
			quoteService.deleteQuoteById(quoteId);
		}

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFound(HttpServletRequest req, ResourceNotFoundException e) {
		ErrorMessage error = new ErrorMessage(e.getErrorMessage(), e.getErrorCode());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}

}
