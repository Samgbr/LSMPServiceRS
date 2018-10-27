package com.lsmp.mp.partner.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.partner.service.representation.PartnerAddressRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerAddressRequest;

@WebService
public interface PartnerAddressService {

	public Set<PartnerAddressRepresentation> getPartnerAddresses(String id);
	public PartnerAddressRepresentation getPartnerAddress(String id);
	public PartnerAddressRepresentation createPartnerAddress(PartnerAddressRequest partnerAddressRequest);
	public Response updatePartnerAddress(PartnerAddressRequest partnerAddressRequest);
    public Response deletePartnerAddress(String id);
}
