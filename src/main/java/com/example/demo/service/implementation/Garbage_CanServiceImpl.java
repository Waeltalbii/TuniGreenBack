package com.example.demo.service.implementation;

import com.example.demo.DAO.Garbage_canDAO;
import com.example.demo.model.Garbage_can;
import com.example.demo.service.interfaces.Garbage_canService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Garbage_CanServiceImpl implements Garbage_canService {
    private final Garbage_canDAO garbageCanDAO ;
    @Override
    public Garbage_can addGarbagecan(Garbage_can garbageCan) {
        return garbageCanDAO.save(garbageCan);
    }
}
