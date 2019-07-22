package com.fse.taskmanager.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fse.taskmanager.model.User;
import com.fse.taskmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public User createUser(User user) {
		User userDetails=null;
		try{
			logger.debug("User Details ::: "+user.getFirst_name()+" ::: "+user.getLast_name()+" ::: "+user.getEmployee_id());
			userDetails = manager.createNamedQuery("callCreateUser", User.class)
					.setParameter(1, user.getFirst_name())
					.setParameter(2, user.getLast_name())
					.setParameter(3, user.getEmployee_id())
					.getSingleResult();
			return userDetails;
		}
		catch(Exception ex){
			logger.error("Issue while creating user in UserServiceImpl: "+ex.getMessage());
		}
		return userDetails;
	}

	@Override
	public List<User> getUserDetails(String sortBy) {
		List<User> userDetails=null;
		try{
			logger.info("sortBy ::: "+sortBy);
			userDetails = manager.createNamedQuery("callGetAllUsers", User.class).setParameter(1, sortBy).getResultList();
			logger.info("userDetails size::: "+userDetails.size());
			return userDetails;
		}
		catch(Exception ex){
			logger.error("Issue while retrieveing all user details in UserServiceImpl: "+ex.getMessage());
		}
		return userDetails;
	}

	@Override
	public User deleteUser(int employeeId) {
		User deleteUser = null;
		try{
			deleteUser = manager.createNamedQuery("callDeleteUser", User.class).setParameter(1, employeeId).getSingleResult();
			return deleteUser;
		}
		catch(Exception ex){
			logger.error("Issue while deleting user details in UserServiceImpl: "+ex.getMessage());
		}
		return deleteUser;
	}
}