package ru.fatkhullin.spring.arsenProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fatkhullin.spring.arsenProject.models.Room;
import ru.fatkhullin.spring.arsenProject.repositories.RoomRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAllByOrderByRoomnumber();
    }
}
