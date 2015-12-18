package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.CreateRoomDto;
import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.enumeration.RoomType;
import cz.muni.fi.pa165.service.HotelService;
import cz.muni.fi.pa165.service.RoomService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link RoomFacade} interface
 *
 * @author Ivo Hradek
 * @see RoomFacade
 */
@Service
@Transactional
public class RoomFacadeImpl implements RoomFacade {
    @Autowired
    private Mapper mapper;

    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;

    @Override
    public RoomDto getRoomById(Long id) {
        return mapper.map(roomService.getRoomDtoById(id), RoomDto.class);
    }

    @Override
    public Collection<RoomDto> getAllRooms() {
        return (Collection) ((List) roomService.getAllRooms()).stream()
                .map(b -> mapper.map(b, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRoom(Long id) {
        roomService.deleteRoom(roomService.getRoomDtoById(id));
    }
    @Override
    public Long createRoom(CreateRoomDto roomDto) {
        Room room = mapper.map(roomDto, Room.class);
        RoomType roomType = roomDto.getRoomType();
        Long hotelId = roomDto.getHotelId();
        Hotel hotel = hotelService.getHotelById(hotelId);
        room.setHotel(hotel);
        room.setType(roomType);
        Room newRoom = roomService.addRoom(room);
        return newRoom.getId();
    }

    @Override
    public void changePrice(Long id, BigDecimal price_bd) {
        roomService.changePrice(price_bd,id);
    }
}
