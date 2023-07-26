package com.example.demo.controller;
import java.io.IOException;
import com.example.demo.model.Offer;
import com.example.demo.service.implementation.OfferServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offer")
@CrossOrigin("*")
public class OfferController {
    private final OfferServiceImpl offerService ;
    @PostMapping("/addOffer")
    public ResponseEntity<?> ajouterOffre(@RequestParam("nom") String nom,
                              @RequestParam("description") String description,
                              @RequestParam("dateCreation") Date creation_date,
                              @RequestParam("dateExpiration") Date expiration_date,
                              @RequestParam("image") MultipartFile picture,
                              @RequestParam("points")Integer points,
                              @RequestParam("namePartner") String namePartner) throws IOException {
         offerService.addOffer(nom, description, creation_date, expiration_date, picture,points,namePartner);
        return ResponseEntity.ok().body("{\"message\": \"Offre ajouter avec succes\"}");    }
    @DeleteMapping("/deleteOffer/{deleteOffer}")
    public ResponseEntity<?> deleteOffer(@PathVariable("deleteOffer") Integer idOffer){
        offerService.deleteOffer(idOffer);
        return ResponseEntity.ok("Offre supprimer avec suces");
    }
    @PutMapping("/updateOffer/{idOffre}")
    public ResponseEntity<String> updateOffre(@RequestParam("nom") String name,
                                      @RequestParam("description") String description,
                                      @RequestParam("dateCreation") Date creation_date,
                                      @RequestParam("dateExpiration") Date expiration_date,
                                      @RequestParam("image") MultipartFile picture,
                                      @RequestParam("points")Integer points,
                                      @RequestParam("namePartner") String namePartner,
                                      @PathVariable("idOffre") Integer idOffer ) throws IOException {
         offerService.updateOffer( idOffer, name,  description,  creation_date,  expiration_date,  picture, points, namePartner);
        return ResponseEntity.ok("Offre modifier avec succés");

    }
        @GetMapping("/getAllOffer")
        public List<Offer> getAllOffer(){
            return offerService.getAllOffer();
        }

    @GetMapping("/getOfferByPartner/{namePartner}")
    public List<Offer> getOfferByPartner(@PathVariable("namePartner") String namePartner){

        return offerService.getOfferByPartner(namePartner);
    }
    @PutMapping("/addOfferToUser/{idUser}/{idOffer}")
    public ResponseEntity<?> addOfferToUser(@PathVariable("idUser") Integer idUser,@PathVariable("idOffer") Integer idOffer){
        offerService.addOfferToUser(idUser,idOffer);
        return ResponseEntity.ok("sucess");

    }
    @GetMapping("/getImageByOfferId/{offerId}")
    public ResponseEntity<?> getImageByOfferId(@PathVariable("offerId") Integer offerId) throws IOException {

        return offerService.getImageOfferByIdOffer(offerId);
    }
}
