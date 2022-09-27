package com.Ebook.Service;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ebook.Entity.User;
import com.Ebook.Entity.UserType;
import com.Ebook.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(AutherImpl.class);

	@Autowired
	private UserRepo userRepo;

	@Override
	public User addUser(User user) {
		String regularExpressionUserName = "^[A-Z][A-Za-z0-9]{3,20}$";
		String regularExpressionpassword = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		if (!user.getUser_name().matches(regularExpressionUserName)) {
			throw new ValidationException("invalid username try again.."
					+ "Rules ,first letter must be an uppercase alphabet and minmum 3 characters");
		}
			else if (!user.getPassword().matches(regularExpressionpassword)) {
				throw new ValidationException("invalid password try again.."
						+ "Minimum eight characters, at least one letter, one number and one special character");
			
			
		}
		logger.info("adding the details ");
		return userRepo.save(user);

	}
}

