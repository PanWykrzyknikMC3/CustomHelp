package customhelp;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Command cmd = command;
		if(cmd.getName().equalsIgnoreCase("help")) {
			List<String> messages = getConfig().getStringList("help");
			for(String m : messages) {
			sender.sendMessage(m.replace("&", "§"));
			}
		}
		if(cmd.getName().equalsIgnoreCase("customhelp")) {//Reload
			sender.sendMessage(ChatColor.GRAY +"Przeladowano "+ "CustomHelp " +"0.1-Stable");
			this.reloadConfig();
			System.out.println("Przeladowano plik config.yml!");
		}
		
			return false;
			
	}
	

	@Override
	public void onDisable() {
		System.out.println("[CustomHelp] Wylaczanie...");
	}

	@Override
	public void onEnable() {
		System.out.println("[CustomHelp] Ladowanie na serwer " +Bukkit.getIp()+"/"+Bukkit.getServerName());
		this.saveDefaultConfig();
		this.reloadConfig();
	}

	@Override
	public void reloadConfig() {
		// TODO Auto-generated method stub
		super.reloadConfig();
	}

	@Override
	public void saveDefaultConfig() {
		// TODO Auto-generated method stub
		super.saveDefaultConfig();
	}
	
}
