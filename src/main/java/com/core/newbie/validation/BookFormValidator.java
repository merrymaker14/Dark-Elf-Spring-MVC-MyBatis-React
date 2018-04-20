//package com.core.newbie.validator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import com.core.newbie.model.Book;
//import com.core.newbie.service.BookService;
//
//@Component
//public class BookFormValidator implements Validator {
//    
//	@Autowired
//	BookService bookService;
//	
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return Book.class.equals(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//
//		Book book = (Book) target;
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.bookForm.name");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty.bookForm.author");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishing_house", "NotEmpty.bookForm.publishing_house");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "the_year_of_publishing", "NotEmpty.bookForm.the_year_of_publishing");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cover","NotEmpty.bookForm.cover");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.bookForm.description");
//		
//		if (book.getName() == null) {
//			errors.rejectValue("name", "Valid.bookForm.framework");
//		}
//		
//		if (book.getAuthor() == null) {
//			errors.rejectValue("framework", "Valid.bookForm.author");
//		}
//		
//		if (book.getPublishingHouse() == null) {
//			errors.rejectValue("framework", "Valid.bookForm.publishing_house");
//		}
//
//		if (book.getTheYearOfPublishing() == null) {
//			errors.rejectValue("the_year_of_publishing", "Valid.bookForm.the_year_of_publishing");
//		}
//		
//		if (book.getCover() == null) {
//			errors.rejectValue("framework", "Valid.bookForm.cover");
//		}
//		
//		if (book.getDescription() == null) {
//			errors.rejectValue("framework", "Valid.bookForm.description");
//		}
//	}
//}