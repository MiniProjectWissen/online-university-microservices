package com.example.auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.dao.UserDao;
import com.example.auth.entity.User;
import com.example.auth.exception.InvalidUserException;

@Service
public class AuthServiceImpl {
	@Autowired
	private UserDao userDao;
	
	public Boolean authenticate(User user)
	{
		
		if(userDao.existsById(user.getEmail())) {
			User dbUser=userDao.findByEmail(user.getEmail());
			if(dbUser.getPassword().equals(user.getPassword()) && 
					dbUser.getRole().equals(user.getRole()) ) {
				return true;
			}
			else {
				throw new InvalidUserException("Invalid Password or role");
			}
		}
		else {
			throw new InvalidUserException("Invalid Email");
		}
		
	}

	public User addUser(User a) {
		if(!userDao.existsById(a.getEmail())) {
			
			
			return userDao.save(a);
		}
		else {
			throw new InvalidUserException("duplicate email");
		}
		
	}
	
	public void deleteUserByEmailId(String email) {
		
		if(userDao.existsById(email)) {
			userDao.deleteById(email);
		}
		else {
			throw new InvalidUserException("No such user");
		}
	}

}





	

	



