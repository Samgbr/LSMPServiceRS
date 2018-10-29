package com.lsmp.mp.partner.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.partner.service.representation.PartnerSmartphoneRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerSmartphoneRequest;

@WebService
public interface PartnerSmartphoneService {

	public Set<PartnerSmartphoneRepresentation> getAllPartnerSmartphones();
	public PartnerSmartphoneRepresentation getPartnerSmarphoneProfileBYProductID(String id);
	public PartnerSmartphoneRepresentation addPartnerSmartphone(PartnerSmartphoneRequest partnerSmartphoneRequest);
	public Response updatePartnerSmartphone(PartnerSmartphoneRequest partnerSmartphoneRequest);
    public Response deletePartnerSmartphone(String id);
}
