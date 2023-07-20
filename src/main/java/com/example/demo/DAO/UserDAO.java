package com.example.demo.DAO;

import com.example.demo.model.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<Appuser,Integer> {
    Appuser findByEmail(String username );
}
