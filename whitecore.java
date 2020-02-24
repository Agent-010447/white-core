package fr.agent040147.whitecore;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class whitecore extends JavaPlugin implements Listener {

	
	public static ArrayList<Player> spying = new ArrayList<>();
	
	@Override
	public void onEnable() {
		System.out.println("White-Core ON");
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
		getCommand("spy").setExecutor(new CommandSpy());
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		System.err.println("White-Core OFF");
		super.onDisable();
	}
	
	
	@EventHandler
	
	public void detectlacommande(PlayerCommandPreprocessEvent e) {
		//perm ignor spy whitecore.spy.ignore
		
		if ((e.getPlayer().hasPermission("whitecore.spy.ignore") && !(e.getPlayer().isOp())) || (e.getPlayer().hasPermission("whitecore.spy.ignore") && (e.getPlayer().isOp())))
			return;
		
		//écoute la console des joueurs
	
		
		for (Player p : whitecore.spying) {
			
		p.sendMessage(e.getPlayer().getName() + ": " + e.getMessage() );	
		
			
		}
	}
}
