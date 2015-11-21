package cz.muni.fi.service.impl;

import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.service.RoomService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jana Cechackova
 */
public class RoomServiceImpl implements RoomService{
    
    RoomDao roomDao;
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public void addRoom(RoomDto roomDto) {
	
	Room room;
	
	room = mapper.map(roomDto, Room.class);
//	roomDto.setId(room.getId());   not included because the method is not implemented yet
	roomDao.addRoom(room);    
    }

    @Override
    public void deleteRoom(RoomDto roomDto) {
	
	Room room;
	
	room = mapper.map(roomDto, Room.class);
	roomDao.deleteRoom(room);    
    }

    @Override
    public void updateRoom(RoomDto roomDto) {
	
	Room room;
    
	room = mapper.map(roomDto, Room.class);
	roomDao.updateRoom(room);
    }

    @Override
    public RoomDto getRoomDtoById(Long id) {
	
	//not implemented yet
	
	return null;    
    } 
}
