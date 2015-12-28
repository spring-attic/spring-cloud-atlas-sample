package atlas;

import com.netflix.spectator.api.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.metrics.atlas.EnableAtlas;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Jon Schneider
 */
@SpringBootApplication
@EnableHystrix // proves that the Spectator Gauge Service is injectable into Hystrix config
@EnableEurekaClient
@RibbonClient(name = "atlas", configuration = AtlasClientConfiguration.class)
@EnableAtlas
@EnableScheduling
public class AtlasApplication {
    @Autowired
    Registry registry;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AtlasApplication.class, args);
	}

    @Scheduled(fixedRate = 5000)
    public void incrementCounter() {
        registry.counter("mycounter").increment();
    }
}
