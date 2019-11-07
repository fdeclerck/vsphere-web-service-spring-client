
package fr.f74;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
// import org.springframework.ws.client.*;
// import org.springframework.ws.soap.*;

import vsphere.wsdl.GetCountryRequest;
import vsphere.wsdl.GetCountryResponse;

public class VsphereClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(VsphereClient.class);

	public GetCountryResponse getCountry(String country) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		return response;
	}

}
