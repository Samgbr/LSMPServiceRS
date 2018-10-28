package com.lsmp.mp.partner.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.partner.service.representation.PartnerBookRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerBookRequest;

@WebService
public interface PartnerBookService {

	public PartnerBookRepresentation getPartnerBookProfileBYProductID(String id);
	public PartnerBookRepresentation addPartnerBook(PartnerBookRequest partnerBookRequest);
	public Response updatePartnerBook(PartnerBookRequest partnerBookRequest);
    public Response deletePartnerBook(String id);
}
