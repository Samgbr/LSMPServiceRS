package com.lsmp.mp.partner.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.partner.service.representation.PartnerRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerRequest;

@WebService
public interface PartnerService {

	//Partner representation and request methods goes here
	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartner(String id);
	public PartnerRepresentation getPartnerByUsernameAndPassword(String id, String pwd);
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);
	public Response updatePartner(PartnerRequest partnerRequest);
    public Response deletePartner(String id);
    
}
