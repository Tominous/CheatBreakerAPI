package gg.kitpvp.cheatbreaker.bungee;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * @author Manny
 * Edgy af and will break later prob
 * To connect to the API, implement @{
 *         <dependency>
            <groupId>gg.kitpvp</groupId>
            <artifactId>cheatbreaker</artifactId>
            <version>LATEST</version>
        </dependency>
 */
public class CheatBreakerAPI extends Plugin {

	/* Singleton instance getter */
	@Getter private static CheatBreakerAPI instance;
	
	@Override
    public void onEnable() {
		instance = this;
		getProxy().getPluginManager().registerListener(this, new ProxyPingListener(this));
	}
	
}
