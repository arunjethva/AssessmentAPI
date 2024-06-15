package com.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Transactional
@Repository
public class UserDaoImpli implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addOrUpdateUser(User u) {

		Session s = sessionFactory.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		s.saveOrUpdate(u);
		tx.commit();
	}

	@Override
	public ArrayList<User> viewAllUser() {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();

		return (ArrayList<User>) s.createQuery("from User").list();
	}

	@Override
	public void deleteUser(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		User u = s.load(User.class, id);
		s.delete(u);
		tx.commit();

	}

	@Override
	public User getById(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		User u = s.load(User.class, id);
		return u;

	}

}
