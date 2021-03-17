#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ping.boundaray;

import ${package}.ping.control.PingManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PingResourceTest {

  private PingResource pingResource;

  @Mock
  private PingManager pingManager;
  private Map<String, Object> pingManagerResponse;

  @BeforeEach
  void setUp() {
    pingResource = new PingResource();
    pingResource.pingManager = pingManager;

    pingManagerResponse = Map.of("Key", UUID.randomUUID());
    when(pingManager.getPing()).thenReturn(pingManagerResponse);
  }

  @Test
  void pingTest() {
    final Map<String, ?> ping = pingResource.ping();

    assertEquals(pingManagerResponse, ping);
    verify(pingManager).getPing();
  }
}
