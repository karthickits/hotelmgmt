package com.mtch.hmgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtch.hmgmt.dao.RoomDao;
import com.mtch.hmgmt.model.Room;
import com.mtch.hmgmt.service.RoomService;

@Service(value="roomService")
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomDao roomDao;
	
	@Override
	public void book(Room room) {
		 roomDao.book(room);
	}

	@Override
	public Room isAvailable(Room room) {
		return roomDao.isAvailable(room);
	}

	@Override
	public List<Room> getAllRooms() {
		return roomDao.getAllRooms();
	}

	@Override
	public List<Room> getAllAvailableRooms() {
		return roomDao.getAllAvailableRooms();
	}

	@Override
	public Room getRoomByRoomNo(long roomNo) {

		List<Room> rooms = roomDao.getRoomByRoomNo(roomNo);
		if (rooms != null && !rooms.isEmpty()) {
			return rooms.get(0);
		}
		return null;
	}

	

}
