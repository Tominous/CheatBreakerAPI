package gg.kitpvp.cheatbreaker.listeners;

import gg.kitpvp.cheatbreaker.CheatBreakerAPI;
import gg.kitpvp.cheatbreaker.configuration.SettingsFile;

import org.bukkit.event.Listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Protocol;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedServerPing;

public class PacketListener implements Listener {

	private CheatBreakerAPI api; //Not even needed :(
	
	public PacketListener(CheatBreakerAPI api) {
		this.api = api;
		SettingsFile settings = api.getSettings();
		if(settings.isKickOnJoin()) {
			ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(api, ListenerPriority.NORMAL, PacketType.Handshake.Client.SET_PROTOCOL, PacketType.Login.Server.DISCONNECT) {
				@Override
				public void onPacketReceiving(PacketEvent event) {
					PacketContainer packet = event.getPacket();
	            
					if (event.getPacketType() == PacketType.Handshake.Client.SET_PROTOCOL) {
						if (packet.getProtocols().read(0) == Protocol.LOGIN) {
	                    	api.getVersions().put(event.getPlayer().getAddress(), packet.getIntegers().read(0));
	                    }
	                } else {
	                    api.getVersions().remove(event.getPlayer().getAddress());
	                }
	            }
	        });
		}
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(api, ListenerPriority.HIGHEST, PacketType.Status.Server.OUT_SERVER_INFO) {
        	@Override
            public void onPacketSending(final PacketEvent event) {
            	WrappedServerPing serverPing = event.getPacket().getServerPings().read(0);
            	serverPing.setVersionProtocol(settings.getProtocolNumber());
            	serverPing.setVersionName(settings.getOutdatedClientMessage());	
            }
        });
	}
	
	
	
}
