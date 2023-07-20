package com.example.demo.DAO;

import com.example.demo.model.Offer;
import com.example.demo.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferDAO extends JpaRepository<Offer,Integer> {

    List<Offer> findByPartner(Partner partner);
}
