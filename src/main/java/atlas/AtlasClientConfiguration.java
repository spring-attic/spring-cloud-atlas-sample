package atlas;

import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.Server;

public class AtlasClientConfiguration {
	@Bean
	public StaticServerList ribbonServerList() {
		return new StaticServerList<Server>(new Server("localhost", 7101));
	}
}
