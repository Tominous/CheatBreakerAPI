package gg.kitpvp.cheatbreaker.bungee;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import org.bukkit.ChatColor;

public class ProxyPingListener implements Listener {

	private CheatBreakerAPI api;
	
	public ProxyPingListener(CheatBreakerAPI api) {
		this.api = api;
	}
	
	@EventHandler
	public void proxyPingEvent(ProxyPingEvent event) {
		ServerPing ping = event.getResponse();
		ping.setVersion(new ServerPing.Protocol("CheatBreaker", -1332));

	}
	
	@EventHandler
	public void postLoginEvent(PostLoginEvent event) {
		if(event.getPlayer().getPendingConnection().getVersion() != -1332) {
			event.getPlayer().disconnect(ChatColor.RED + "You must connect with CheatBreaker to connect to this server!");
		}
	}

}
