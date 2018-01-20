package me.gl1tchcraft.economy.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.economy.Main;

public class PayCommand implements CommandExecutor {

    private Main plugin = Main.getInstance;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("pay")) {
            	if(p.hasPermission("pay.economy.gl1tchcraft")) {
            		if(args.length == 2) {
            			Player target = Bukkit.getPlayer(args[0]);
            			Double amount = Double.parseDouble(args[1]);
            			if(target != null) {
            				double senderbalance = plugin.economyImplementer.getBalance(p);
            				
            				if((senderbalance - amount) >= 0) {
            					plugin.economyImplementer.withdrawPlayer(p, amount);
            					plugin.economyImplementer.depositPlayer(target, amount);
            					p.sendMessage(ChatColor.GRAY + "You have " + ChatColor.GREEN + "$" + plugin.economyImplementer.getBalance(p) + ChatColor.GRAY + " in your account.");
            					target.sendMessage(ChatColor.GRAY + "You have been payed " + ChatColor.GREEN + "$" + amount + ChatColor.GRAY + " by " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + ".");
            					target.sendMessage(ChatColor.GRAY + "You have " + ChatColor.GREEN + "$" + plugin.economyImplementer.getBalance(target) + ChatColor.GRAY + " in your account.");
            				} else {
            					p.sendMessage(ChatColor.RED + "You don't have enough money to do that!");
            				}
            			} else {
            				p.sendMessage(ChatColor.RED + "Can't find " + ChatColor.GOLD + args[0]);
            			}
            		} else {
            			p.sendMessage(ChatColor.RED + "Incorrect Arguments.. '/pay {name} {amount}'");
            		}
            	} else {
            		p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
            	}
            }
            
        }
        return true;
    }

}
