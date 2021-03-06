package me.gl1tchcraft.economy.methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.ServicePriority;

import me.gl1tchcraft.economy.Main;
import net.milkbowl.vault.economy.Economy;

public class VaultHook {

    private Main plugin = Main.getInstance;

    private Economy provider;

    public void hook() {
        provider = plugin.economyImplementer;
        Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "VaultAPI hooked into " + ChatColor.AQUA + plugin.getName());
    }

    public void unhook() {
        Bukkit.getServicesManager().unregister(Economy.class, this.provider);
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "VaultAPI unhooked from " + ChatColor.AQUA + plugin.getName());

    }
}
