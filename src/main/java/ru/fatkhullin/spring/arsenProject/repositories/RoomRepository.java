package ru.fatkhullin.spring.arsenProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.fatkhullin.spring.arsenProject.models.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByOrderByRoomnumber();

}
