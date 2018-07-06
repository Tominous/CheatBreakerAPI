package gg.kitpvp.cheatbreaker.channels;

import gg.kitpvp.cheatbreaker.CheatBreakerAPI;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessagingListeners implements PluginMessageListener {

	private CheatBreakerAPI api;
	
	public PluginMessagingListeners(CheatBreakerAPI api) {
		this.api = api;
	}

	@Override
	 public void onPluginMessageReceived(String channel, Player player, byte[] args) {
        if (channel.equals("CB|INIT") || channel.equals("CB-Binary")) {
        	if(!api.getVersions().containsKey(player.getAddress())) {
        		api.getVersions().put(player.getAddress(), api.getSettings().getProtocolNumber());
        	}
        }
	}
	
}
