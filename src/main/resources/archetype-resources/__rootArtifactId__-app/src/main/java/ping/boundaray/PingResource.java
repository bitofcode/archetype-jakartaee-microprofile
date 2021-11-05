#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ping.boundaray;

import ${package}.ping.control.PingManager;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

@RequestScoped
@Path("/ping")
@Produces({MediaType.APPLICATION_JSON})
public class PingResource {

  @Inject
  PingManager pingManager;

  @GET
  public Map<String, Object> ping() {
    return pingManager.getPing();
  }
}
