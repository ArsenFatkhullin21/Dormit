package ru.fatkhullin.spring.arsenProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fatkhullin.spring.arsenProject.models.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findAllByOrderByRoom_Roomnumber();

    Person findByIdAndRoomIsNull(int id);

    Person findByIdAndRoomIsNotNull(int id);

    List<Person> findALLByRoomIsNullOrderByFio();

    List<Person> findAllByRoom_RoomnumberIsNotNullOrderByRoom_Roomnumber();

    List<Person> findAllByRoomIsNullOrderByFio();

    List<Person> findAllByOrderByFio();

    List<Person> findPersonsByRoom_RoomnumberOrderByFio(int roomnumber);

}
