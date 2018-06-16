package gg.kitpvp.cheatbreaker.listeners;

import gg.kitpvp.cheatbreaker.CheatBreakerAPI;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implement Listener {

	private CheatBreakerAPI api;
	
	public PlayerListener(CheatBreakerAPI api) {
		this.api = api;
	}
	
	@EventHandler
	public void onJoin(AsyncPlayerPreLoginEvent event) {
		if(api.getSettings().isKickOnJoin()) {
			if(api.getVersions().containsKey(event.getAddress()) && api.getVersions().get(event.getAddress()) != api.getSettings().getProtocolNumber()) {
				event.setResult(Result.KICK_OTHER);
				event.setKickMessage(ChatColor.translateAlternateColorCodes('&', api.getSettings().getKickMessage()));
			}
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(api.getVersions().containsKey(event.getPlayer().getAddress())) {
			api.getVersions().remove(event.getPlayer().getAddress());
		}
	}
}
