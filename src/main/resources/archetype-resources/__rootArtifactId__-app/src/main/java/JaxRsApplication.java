#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId};

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/resources")
public class JaxRsApplication extends Application {

  @Liveness
  @Produces
  public HealthCheck aliveness() {
    return () -> HealthCheckResponse.up("live " + getClass().getSimpleName());
  }

  @Readiness
  @Produces
  public HealthCheck readiness() {
    return () -> HealthCheckResponse.up("ready " + getClass().getSimpleName());
  }
}
