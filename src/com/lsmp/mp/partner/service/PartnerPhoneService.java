package com.lsmp.mp.partner.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.partner.service.representation.PartnerPhoneRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerPhoneRequest;

@WebService
public interface PartnerPhoneService {

	public Set<PartnerPhoneRepresentation> getPartnerPhones(String id);
	public PartnerPhoneRepresentation getPartnerPhone(String id);
	public PartnerPhoneRepresentation insertPartnerPhone(PartnerPhoneRequest partnerPhoneRequest);
	public Response updatePartnerPhone(PartnerPhoneRequest partnerPhoneRequest);
    public Response deletePartnerPhone(String id);
}
