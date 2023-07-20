package com.example.demo.service.implementation;

import com.example.demo.DAO.OfferDAO;
import com.example.demo.DAO.PartnerDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.Appuser;
import com.example.demo.model.Offer;
import com.example.demo.model.Partner;
import com.example.demo.service.interfaces.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferDAO offerDAO ;
    private final PartnerDAO partnerDAO ;
    private final UserDAO userDAO;
    @Value("${upload.directory}")
    private String uploadDirectory;
    @Override
    public Offer addOffer(String name, String description, Date creation_date, Date expiration_date, MultipartFile picture,Integer points,String namePartner) throws IOException {
        Partner p = partnerDAO.findByNamePartner(namePartner);
        Offer offer = new Offer();
        offer.setName(name);
        offer.setDescription(description);
        offer.setCreation_date(creation_date);
        offer.setExpiration_date(expiration_date);
        offer.setPoints(points);
        offer.setPartner(p);
        if (!picture.isEmpty()) {
            byte[] pictureBytes = picture.getBytes();
            Path picturePath = Paths.get(uploadDirectory + picture.getOriginalFilename());
            Files.write(picturePath, pictureBytes);
            offer.setPictureUrl(picturePath.toString());
        }
        return offerDAO.save(offer);
    }

    @Override
    public void deleteOffer(Integer idOffer) {
           offerDAO.deleteById(idOffer);
    }

    @Override
    public Offer updateOffer(Integer idOffer,String name, String description, Date creation_date, Date expiration_date, MultipartFile picture,Integer points,String namePartner) throws IOException {
        Offer of = offerDAO.findById(idOffer).get();
        Partner pm = partnerDAO.findByNamePartner(namePartner);
        of.setName(name);
        of.setPoints(points);
        of.setCreation_date(creation_date);
        of.setExpiration_date(expiration_date);
        of.setDescription(description);
        of.setPartner(pm);
        if (!picture.isEmpty()) {
            byte[] pictureBytes = picture.getBytes();
            Path picturePath = Paths.get(uploadDirectory + picture.getOriginalFilename());
            Files.write(picturePath, pictureBytes);
            of.setPictureUrl(picturePath.toString());
        }
        return offerDAO.save(of);
    }

    @Override
    public List<Offer> getAllOffer() {

        return offerDAO.findAll();
    }

    @Override
    public List<Offer> getOfferByPartner(String namePartner) {
        Partner p = partnerDAO.findByNamePartner(namePartner);
        return offerDAO.findByPartner(p);
    }

    @Override
    public void addOfferToUser(Integer idUser, Integer idOffer) {
        Offer offer = offerDAO.findById(idOffer).get();
        Appuser appuser = userDAO.findById(idUser).get();
        if(appuser.getPointsOfUser() >= offer.getPoints()){
           offer.getAppusers().add(appuser);
           offerDAO.save(offer);
        }
        else System.out.println("votre points n'ont pas suffisant");
    }
}
