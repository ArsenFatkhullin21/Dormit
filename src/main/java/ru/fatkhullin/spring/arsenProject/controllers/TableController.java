package ru.fatkhullin.spring.arsenProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fatkhullin.spring.arsenProject.services.PersonService;
import ru.fatkhullin.spring.arsenProject.services.RoomService;

@Controller
@RequestMapping("/table")
public class TableController {

    private final PersonService personService;
    private final RoomService roomService;

    public TableController(PersonService personService, RoomService roomService) {
        this.personService = personService;
        this.roomService = roomService;
    }

    @GetMapping()
    public String with(Model model) {
        model.addAttribute("people", personService.findAll());
        return "table/peoplewithroom";
    }

}
