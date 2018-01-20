package me.gl1tchcraft.economy.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.economy.Main;

public class BalanceCommand implements CommandExecutor {

    private Main plugin = Main.getInstance;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (command.getName().equalsIgnoreCase("balance")) {
            	
                if(args.length == 0) {
                	if(p.hasPermission("balance.economy.gl1tchcraft")) {
                    	
                        boolean account = plugin.economyImplementer.hasAccount(p);
                        if(account == false) {
                        	plugin.economyImplementer.createPlayerAccount(p);           
                        }
                        	
                		double balance = plugin.economyImplementer.getBalance(p);
                		p.sendMessage(ChatColor.GRAY + "You have " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in your account.");
                	} else {
                		p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                	}
                }
                if(args.length == 1) {
                	if(p.hasPermission("balanceothers.economy.gl1tchcraft")) {
                		Player target = Bukkit.getPlayer(args[0]);
                		if(target != null) {
                			
                            boolean account = plugin.economyImplementer.hasAccount(target);
                            if(account == false) {
                            	plugin.economyImplementer.createPlayerAccount(target);                             
                            }
                			
                			double balance = plugin.economyImplementer.getBalance(target);
                			p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " has " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in their account.");
                		} else {
                			p.sendMessage(ChatColor.RED + "Can't find " + ChatColor.GOLD + args[0]);
                		}
                	} else {
                		p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                	}
                }
            }
        }
        return true;
    }
}
