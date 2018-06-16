package gg.kitpvp.cheatbreaker;

import gg.kitpvp.cheatbreaker.configuration.SettingsFile;
import gg.kitpvp.cheatbreaker.listeners.PacketListener;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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
public class CheatBreakerAPI extends JavaPlugin {

	/* Singleton instance getter */
	@Getter private CheatBreakerAPI instance;
	
	@Getter private SettingsFile settings; //Lazy and edgy af
	
	@Getter	private Map<InetSocketAddress, Integer> versions;

    @Override
    public void onEnable() {
        instance = this;
        
        if (!new File(getDataFolder(), "config.yml").exists()) {
            this.saveDefaultConfig();
            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        }
        this.versions = new ConcurrentHashMap<InetSocketAddress, Integer>();
        this.settings = new SettingsFile(this);
        if(settings.isEnabled()) {
        	getServer().getPluginManager().registerEvents(new PacketListener(this), this);
        }
    }
    
    public boolean onCheatBreaker(Player player) {
    	if(this.versions.containsKey(player.getAddress()) && this.versions.get(player.getAddress()) == this.settings.getProtocolNumber()) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public void onDisable() {
    	settings.save();
    }
	
}
