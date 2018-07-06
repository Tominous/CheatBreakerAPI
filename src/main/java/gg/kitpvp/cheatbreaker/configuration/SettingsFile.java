package gg.kitpvp.cheatbreaker.configuration;

import gg.kitpvp.cheatbreaker.CheatBreakerAPI;
import lombok.Data;

import org.bukkit.configuration.file.FileConfiguration;

@Data
public class SettingsFile {

	private CheatBreakerAPI api;
	
	private boolean enabled;
	private boolean channels;
	
	private int protocolNumber;
	private String outdatedClientMessage;
	
	private boolean kickOnJoin;
	private String kickMessage;
	
	
	
	public SettingsFile(CheatBreakerAPI api) {
		this.api = api;
		init();
	}
	
	public void init() {
		FileConfiguration config = api.getConfig();
		this.enabled = config.getBoolean("ENABLED");
		this.protocolNumber = config.getInt("PROTOCOL_NUMBER");
		this.channels = config.getBoolean("CHANNELS");
		this.outdatedClientMessage = config.getString("OUTDATED_CLIENT_MESSAGE");
		this.kickOnJoin = config.getBoolean("KICK.ON_JOIN");
		this.kickMessage = config.getString("KICK.MESSAGE");	
	}
	
	public void save() {
		FileConfiguration config = api.getConfig();
		config.set("ENABLED", this.enabled);
		config.set("PROTOCOL_NUMBER", protocolNumber);
		config.set("OUTDATED_CLIENT_MESSAGE", this.outdatedClientMessage);
		config.set("KICK.ON_JOIN", this.kickMessage);
		config.set("KICK.MESSAGE", this.kickMessage);
		api.saveConfig();
	}
}
