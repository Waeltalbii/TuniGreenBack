package com.example.demo.DAO;

import com.example.demo.model.Garbage_can;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Garbage_canDAO extends JpaRepository<Garbage_can,Integer> {
}
