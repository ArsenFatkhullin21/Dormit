package ru.fatkhullin.spring.arsenProject.services;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fatkhullin.spring.arsenProject.models.Person;
import ru.fatkhullin.spring.arsenProject.repositories.PersonRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAllByOrderByRoom_Roomnumber();
    }


    public List<Person> findAllByRoomIsNullOrderByFio(){
        return personRepository.findAllByRoomIsNullOrderByFio();
    }

    public List<Person> findAllByRoom_RoomnumberIsNotNullOrderByRoom_Roomnumber() {
        return personRepository.findAllByRoom_RoomnumberIsNotNullOrderByRoom_Roomnumber();
    }

    public Person findById(int id) {

        if(personRepository.findByIdAndRoomIsNull(id)!=null) {
            return personRepository.findByIdAndRoomIsNull(id);
        } else if (personRepository.findByIdAndRoomIsNotNull(id)!=null) {
            return personRepository.findByIdAndRoomIsNotNull(id);
        } else {
            return null;
        }

    }

    public List<Person> findPersonByRoomNumber(int roomNumber) {
        return personRepository.findPersonsByRoom_RoomnumberOrderByFio(roomNumber);
    }





    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void update(int id,Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }


}
