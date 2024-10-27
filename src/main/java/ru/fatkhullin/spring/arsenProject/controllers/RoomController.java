package ru.fatkhullin.spring.arsenProject.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fatkhullin.spring.arsenProject.models.Room;
import ru.fatkhullin.spring.arsenProject.services.PersonService;
import ru.fatkhullin.spring.arsenProject.services.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;
    private final PersonService personService;

    @Autowired
    public RoomController(RoomService roomService, PersonService personService) {
        this.roomService = roomService;
        this.personService = personService;
    }

    @GetMapping()
    public String rooms(Model model) {
        model.addAttribute("rooms", personService.findAll());

        return "room/rooms";
    }

    @GetMapping("/{roomNumber}")
    public String room(@PathVariable int roomNumber, Model model) {
        model.addAttribute("room", personService.findPersonByRoomNumber(roomNumber));
        return "room/residents";
    }
}
