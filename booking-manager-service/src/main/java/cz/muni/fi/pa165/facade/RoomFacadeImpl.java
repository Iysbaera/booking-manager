package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.service.RoomService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Implementation of {@link cz.muni.fi.pa165.facade.RoomFacade} interface
 *
 * @see cz.muni.fi.pa165.facade.RoomFacade
 * @author Ivo Hradek
 */
@Transactional
@Service("roomFacade")
public class RoomFacadeImpl implements RoomFacade {
    @Autowired
    private Mapper mapper;

    @Autowired
    private RoomService roomService;

    @Override
    public RoomDto getRoomById(Long id) {
        return mapper.map(roomService.getRoomDtoById(id), RoomDto.class);
    }

    @Override
    public Collection<RoomDto> getAllHotelRooms(Hotel hotel) {
        return null;
    }

    @Override
    public Collection<RoomDto> getAllRooms() {
        return null;
    }
}
