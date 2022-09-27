package com.Ebook.Service;

import java.util.List;


import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ebook.Entity.Author;
import com.Ebook.Entity.UserType;
import com.Ebook.Exception.ResourceNotFoundException;
import com.Ebook.Repository.AuthorRepository;

@Service
public class AutherImpl implements AutherService {

	private static final Logger logger = LoggerFactory.getLogger(AutherImpl.class);

	@Autowired
	private AuthorRepository authorrepository;

	@Override
	public Author AddDetails(Author author) {
		String regex = "\\d+";
		String regularExpressionpassword = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		String regularExpressionUserName = "^[A-Z][A-Za-z0-9]{3,20}$";
		
		try {
			if (!(author.getUsertype().equals(UserType.AUTHOR) || author.getUsertype().equals(UserType.USER))) {
				throw new ValidationException("invalid usertype we have only 2 usertpes   1)USER    2)AUTHOR");
			}
		} catch (Exception x) {
			System.out.println("excption handled");
		}

		if (author.getMobileNumber().length() != 10 || !author.getMobileNumber().matches(regex)) {
			if (!author.getMobileNumber().matches(regex))
				throw new ValidationException("mobile number contains only numericals");

			else if (author.getMobileNumber().length() != 10)
				throw new ValidationException("please the length of the mobile number must be 10");

		}

		else if (!author.getPassword().matches(regularExpressionpassword)) {
			throw new ValidationException("invalid password try again.."
					+ "Minimum eight characters, at least one letter, one number and one special character");
		}
		
		else if (!author.getUserName().matches(regularExpressionUserName)) {
			throw new ValidationException("invalid username try again.."
					+ "Rules --> first letter must be an uppercase alphabet and minmum 3 characters");
					
		}
		logger.info("adding the details ");
		return authorrepository.save(author);
	}

	@Override
	public List<Author> getDetails() {
		return authorrepository.findAll();
	}

	@Override
	public String deleteRegister(Long registernumber) throws ResourceNotFoundException {
		String output = "";
		Author check = authorrepository.findByRegistrationNumber(registernumber);
		System.out.println("register number passed by user= "+registernumber+" registernumber from database= "+check.getRegistrationNumber());
		if (!(check.getRegistrationNumber().equals(registernumber))) {
			System.out.println( registernumber + " is of type " + registernumber.getClass().getSimpleName());
			System.out.println("register number passed by user="+registernumber+"registernumber from database="+check.getRegistrationNumber()+"ifvaluse");
			System.out.println( check + " is of type " + check.getRegistrationNumber().getClass().getSimpleName());
			throw new ResourceNotFoundException("Register number Not found");
		} else {
			authorrepository.delete(check);
			output = "register deleted";
		}
		return output;
	}

	public Author updateAuthorDetails(Author author, Long authorId) throws ResourceNotFoundException {
		logger.info("User Service Update");
		Author check = authorrepository.findByRegistrationNumber(authorId);
		if(check==null) {
			throw  new ResourceNotFoundException("User not found for this id " + authorId);
		}
		check.setEmail(author.getEmail());
		check.setMobileNumber(author.getMobileNumber());
		check.setUserName(author.getUserName());
		check.setPassword(author.getPassword());
		check.setUsertype(author.getUsertype());
		final Author updateAuthor = authorrepository.save(check);
		return updateAuthor;
	}

	@Override
	public Author findUserById(Long registrationnumber) {
     logger.info("get register by registernumber");
     Author author=authorrepository.findByRegistrationNumber(registrationnumber);	
		if(author==null) {
			new ResourceNotFoundException("register details not found for this id");
		}
		return author;
	}
}