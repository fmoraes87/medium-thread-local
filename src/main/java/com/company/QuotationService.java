package com.company;

import jakarta.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class QuotationService {

  public BigDecimal getQuotationWithThreadLocal(String currencyOut){
    var userLocation = Notepad.getContextValue(Notepad.USER_CURRENT_LOCATION);
    var userId = Notepad.getContextValue(Notepad.USER_ID);

    //varios calculos de rate limit baseado na localizacao do usuario e na moeda desejada
    //chamada para outras APIs e etc
    return BigDecimal.ZERO;
  }

  public BigDecimal quotationWithOutThreadLocal(
      String currencyOut
      , String userLocation
      , String userId ){

    //varios calculos de rate limit baseado na localizacao do usuario e na moeda desejada
    //chamada para outras APIs e etc

    return BigDecimal.ZERO;

  }

}
