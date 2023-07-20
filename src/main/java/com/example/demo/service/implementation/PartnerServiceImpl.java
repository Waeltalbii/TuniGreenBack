package com.example.demo.service.implementation;

import com.example.demo.DAO.PartnerDAO;
import com.example.demo.model.Partner;
import com.example.demo.service.interfaces.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerDAO partnerDAO ;

    @Override
    public Partner addPartner(Partner partner) {
        Partner p = new Partner() ;
          p.setNamePartner(partner.getNamePartner());
          p.setDescriptionPartner(partner.getDescriptionPartner());
          partnerDAO.save(p);
        return p;
    }

    @Override
    public void deletePartner(Integer idPartner) {
        partnerDAO.deleteById(idPartner);

    }

    @Override
    public Partner updatePartner(Integer idPartner,Partner partner) {
        Partner p = partnerDAO.findById(idPartner).get();
        p.setDescriptionPartner(partner.getDescriptionPartner());
        p.setNamePartner(partner.getNamePartner());
        return partnerDAO.save(p);
    }

    @Override
    public List<Partner> getAllPartner() {

        return partnerDAO.findAll();
    }
}
