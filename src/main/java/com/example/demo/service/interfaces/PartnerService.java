package com.example.demo.service.interfaces;

import com.example.demo.model.Partner;

import java.util.List;

public interface PartnerService {
   Partner addPartner(Partner partner);
   void deletePartner(Integer idPartner);
   Partner updatePartner(Integer idPartner,Partner partner);
   List<Partner> getAllPartner();
}
