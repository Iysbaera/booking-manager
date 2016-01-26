/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.rest.controllers;

import cz.muni.fi.pa165.dto.CreateRoomDto;
import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.facade.RoomFacade;
import cz.muni.fi.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.muni.fi.pa165.rest.exceptions.ResourceNotFoundException;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
/**
 *
 * @author Juraj Bielik
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Inject
    private RoomFacade roomFacade;

    /**
     * Get list of Products curl -i -X GET http://localhost:8080/pa165/rest/room
     *
     * @return RoomDTO
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Collection<RoomDto> getRooms() {
        return roomFacade.getAllRooms();
    }

    /**
     *
     * Get Product by identifier id curl -i -X GET
     * http://localhost:8080/pa165/rest/room/{id}
     *
     * @param id identifier for a product
     * @return RoomtDTO
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final RoomDto getRoom(@PathVariable("id") long id) throws Exception {
        RoomDto roomDto;
        try {
            roomDto = roomFacade.getRoomById(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
        if (roomDto != null) {
            return roomDto;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * Delete one product by id curl -i -X DELETE
     * http://localhost:8080/pa165/rest/room/{id}
     *
     * @param id identifier for product
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteRoom(@PathVariable("id") long id) throws Exception {
        try {
            roomFacade.deleteRoom(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * Create a new product by POST method curl -X POST -i -H "Content-Type:
     * application/json" --data
     * '{"name":"TEST","numberOfBeds":2,"price":25.20,"hotel":{"id":2,
     * "name":"Park Hotel","address":"Praha","description":"Pekny hotel v
     * Prahe", "lastUpdateDay":"2016-07-27 00:00"},"reservations":[]}'
     * http://localhost:8080/pa165/rest/room/create
     *
     * @param roomDTO roomCreateDTO with required fields for creation
     * @throws ResourceAlreadyExistingException
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final void createRoom(@RequestBody CreateRoomDto roomDto) throws Exception {

        try {
            roomFacade.createRoom(roomDto);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }
}
