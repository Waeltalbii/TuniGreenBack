package com.example.demo.controller;

import com.example.demo.model.Partner;
import com.example.demo.service.implementation.PartnerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partner")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PartnerController {

    private final PartnerServiceImpl partnerService ;


    @PostMapping("/addPartner")
    public Partner addPartner(@RequestBody Partner partner){
       return partnerService.addPartner(partner);
   }
   @DeleteMapping("/deletePartner/{idPartner}")
    public void deletePartner(@PathVariable("idPartner") Integer idPartner){
        partnerService.deletePartner(idPartner);

    }
    @PutMapping("/updatePartner/{idPartner}")
    public ResponseEntity<?> updatePartner(@PathVariable("idPartner") Integer idPartner,@RequestBody Partner partner){
        partnerService.updatePartner(idPartner,partner);
        return ResponseEntity.ok("partenaire modifier avec succes");
    }
   @GetMapping("/gettAllPartner")
    public List<Partner> getAllPartner(){
        return partnerService.getAllPartner();
    }
}
