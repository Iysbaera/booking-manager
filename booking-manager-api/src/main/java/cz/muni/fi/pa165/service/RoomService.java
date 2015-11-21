package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dto.RoomDto;

/**
 *
 * @author Jana Cechackova
 */
public interface RoomService {
    
    public void addRoom(RoomDto roomDto);
    public void deleteRoom(RoomDto roomDto);
    public void updateRoom(RoomDto roomDto);
    public RoomDto getRoomDtoById(Long id);
    
}
