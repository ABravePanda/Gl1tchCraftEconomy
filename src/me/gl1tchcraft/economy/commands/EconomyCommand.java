package me.gl1tchcraft.economy.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.economy.Main;

public class EconomyCommand implements CommandExecutor {

    private Main plugin = Main.getInstance;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("economy")) {
            	if(args.length == 3) {
                	
                	if(args[0].equalsIgnoreCase("set")) {
                		if(p.hasPermission("set.economy.gl1tchcraft")) {
                			Player target = Bukkit.getPlayer(args[1]);
                			if(target != null) {
                				double amount = Double.parseDouble(args[2]);
                				
                     			boolean account = plugin.economyImplementer.hasAccount(target);
                                if(account == false) {
                                	plugin.economyImplementer.createPlayerAccount(target);           
                                }
                                
        							boolean success = plugin.economyImplementer.setBalance(target, amount);
        							if(success == true) {
        								double balance = plugin.economyImplementer.getBalance(target);
        								target.sendMessage(ChatColor.GRAY + "You have " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in your account.");
        								p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " has " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in their account.");
        							} else {
        								p.sendMessage(ChatColor.RED + "Uh oh! Something went wrong!");
        							}
                				
                			} else {
                				p.sendMessage(ChatColor.RED + "Can't find " + ChatColor.GOLD + args[1]);
                			}
                			
                		} else {
                			p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                		}
                	}
                	if(args[0].equalsIgnoreCase("add")) {
                		if(p.hasPermission("add.economy.gl1tchcraft")) {
                			
                			Player target = Bukkit.getPlayer(args[1]);
                			if(target != null) {
                				double amount = Double.parseDouble(args[2]);
                				
                     			boolean account = plugin.economyImplementer.hasAccount(target);
                                if(account == false) {
                                	plugin.economyImplementer.createPlayerAccount(target);           
                                }
                                
        							plugin.economyImplementer.depositPlayer(target, amount);
        							double balance = plugin.economyImplementer.getBalance(target);
        							target.sendMessage(ChatColor.GRAY + "You have " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in your account.");
        							p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " has " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in their account.");
                				
                			} else {
                				p.sendMessage(ChatColor.RED + "Can't find " + ChatColor.GOLD + args[1]);
                			}
                			
                		} else {
                			p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                		}
                	}
                	if(args[0].equalsIgnoreCase("remove")) {
                		if(p.hasPermission("add.economy.gl1tchcraft")) {
                			
                			Player target = Bukkit.getPlayer(args[1]);
                			if(target != null) {
                				double amount = Double.parseDouble(args[2]);
                				
                     			boolean account = plugin.economyImplementer.hasAccount(target);
                                if(account == false) {
                                	plugin.economyImplementer.createPlayerAccount(target);           
                                }
                                
        							plugin.economyImplementer.withdrawPlayer(target, amount);
        							double balance = plugin.economyImplementer.getBalance(target);
        							target.sendMessage(ChatColor.GRAY + "You have " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in your account.");
        							p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " has " + ChatColor.GREEN + "$" + balance + ChatColor.GRAY + " in their account.");
                				
                			} else {
                				p.sendMessage(ChatColor.RED + "Can't find " + ChatColor.GOLD + args[1]);
                			}
                			
                		} else {
                			p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                		}
                	}
            	} else {
            		p.sendMessage(ChatColor.RED + "Incorrect Arguments.. '/economy [set,add,remove] {name} {amount}'");
            	}
            }
            
        }
        
        return true;
    }

}
