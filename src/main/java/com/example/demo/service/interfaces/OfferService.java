package com.example.demo.service.interfaces;

import com.example.demo.model.Offer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface OfferService {
    Offer addOffer (String nom, String description,
                    Date dateCreation, Date dateExpiration,
                    MultipartFile picture,Integer points,String namePartner) throws IOException;
    void deleteOffer(Integer idOffer);
    Offer updateOffer(Integer idOffer,String name, String description, Date creation_date, Date expiration_date, MultipartFile picture,Integer points,String namePartner) throws IOException;
    List<Offer> getAllOffer();
    List<Offer> getOfferByPartner(String namePartner);
    void addOfferToUser(Integer idUser,Integer idOffer);
    ResponseEntity<?> getImageOfferByIdOffer(Integer idOffer) throws IOException;
}
