package com.company;

import jakarta.ws.rs.container.ContainerRequestContext;
import java.util.Properties;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

public class ContextFilter {

  //REF: https://quarkus.io/guides/resteasy-reactive#request-or-response-filters
  //You can declare functions which are invoked
  //after routing, but before the endpoint method is called: normal request filter
  @ServerRequestFilter
  public void filter(final ContainerRequestContext containerRequestContext) {
    //Quando chegar a requisicao, inicializamos o bloco de anotacoes
    Notepad.setCtx(new Properties());

    //Vamos supor, que informacoes venham no header da aplicacao
    //E voce precisa delas em diversas camadas para fazer diversas tratativas
    Notepad.setContextValue(Notepad.USER_ID,getParam(containerRequestContext,Notepad.USER_ID));
    Notepad.setContextValue(Notepad.USER_CURRENT_LOCATION,getParam(containerRequestContext,Notepad.USER_CURRENT_LOCATION));


  }

  public String getParam(final ContainerRequestContext containerRequestContext, String param){
      return containerRequestContext.getHeaderString(param);
  }

}
