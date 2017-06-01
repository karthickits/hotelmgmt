package com.mtch.hmgmt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mtch.hmgmt.dao.RoomDao;
import com.mtch.hmgmt.model.Room;

@Repository
public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao {
	
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	@Override
	public void book(Room room) {
		getHibernateTemplate().saveOrUpdate(room);
	}

	@Override
	public Room isAvailable(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getAllRooms() {
		return  (List<Room>) getHibernateTemplate().find("from Room");
	}

	@Override
	public List<Room> getAllAvailableRooms() {
		return  (List<Room>) getHibernateTemplate().find("from Room where isAvailable = true");
	}
	
	public List<Room> getRoomByRoomNo(long roomNo){
		return  (List<Room>) getHibernateTemplate().find("from Room where roomNo = true");
	}

}
