package ru.fatkhullin.spring.arsenProject.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.fatkhullin.spring.arsenProject.models.Person;
import ru.fatkhullin.spring.arsenProject.services.PersonService;
import ru.fatkhullin.spring.arsenProject.services.RoomService;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;
    private final RoomService roomService;

    @Autowired
    public PersonController(PersonService personService, RoomService roomService) {
        this.personService = personService;
        this.roomService = roomService;
    }


    @GetMapping()
    public String allPersons(Model model) {
        model.addAttribute("people",personService.findAll());
        return "people/people";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("rooms", roomService.findAll());
        return "people/newPeople";
    }

    @PostMapping()
    public String savePerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "people/newPeople";
        }

        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.findById(id));
        model.addAttribute("rooms", roomService.findAll());
        return "people/editPerson";
    }

    @PatchMapping("/{id}")
    public String updatePerson( @PathVariable int id, @ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "people/editPerson";
        }

        personService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/people";
    }
}
