package com.company;

import io.vertx.core.http.HttpServerRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/quotation")
public class QuotationResource {

    @Inject QuotationService quotationService;

    //currency => moeda desejada
    @Path("/withThreadLocal")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public BigDecimal quotationWithThreadLocal(@QueryParam("currency") final String currency) {

        return quotationService.getQuotationWithThreadLocal(currency);

    }

    //@Context final HttpServerRequest request -> onde temos acesso a todos os dados da requisição
    //currency => moeda desejada
    @Path("/withoutThreadLocal")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public BigDecimal quotationWithOutThreadLocal(@Context final HttpServerRequest request,
        @QueryParam("currency") final String currency) {


        var userId = request.getHeader(Notepad.USER_ID);
        var userCurrentLocation = request.getHeader(Notepad.USER_CURRENT_LOCATION);

        return quotationService.quotationWithOutThreadLocal(currency,userCurrentLocation,userId);

    }

}
