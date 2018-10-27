package com.lsmp.mp.partner.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.partner.service.representation.PartnerBillingRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerBillingRequest;

@WebService
public interface PartnerBillingService {

	public Set<PartnerBillingRepresentation> getPartnerBillingInfos(String id);
	public PartnerBillingRepresentation getPartnerBillingInfo(String id);
	public PartnerBillingRepresentation insertPartnerBillingInfo(PartnerBillingRequest partnerBillingRequest);
	public Response updatePartnerBillingInfo(PartnerBillingRequest partnerBillingRequest);
    public Response deletePartnerBillingInfo(String id);
}
