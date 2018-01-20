package me.gl1tchcraft.economy;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.gl1tchcraft.economy.commands.BalanceCommand;
import me.gl1tchcraft.economy.commands.EconomyCommand;
import me.gl1tchcraft.economy.commands.PayCommand;
import me.gl1tchcraft.economy.methods.EconomyImplementer;
import me.gl1tchcraft.economy.methods.VaultHook;

public class Main extends JavaPlugin implements Listener{

    public static Main getInstance;
    public EconomyImplementer economyImplementer;
    private VaultHook vaultHook;

    public final HashMap<UUID,Double> playerBank = new HashMap<>();

    public void onEnable() {
        runOnEnable();
    }

    private void instanceClasses() {
        getInstance = this;
        economyImplementer = new EconomyImplementer();
        vaultHook = new VaultHook();
    }

    public void runOnEnable(){
        instanceClasses();
        vaultHook.hook();
        this.getCommand("balance").setExecutor(new BalanceCommand());
        this.getCommand("economy").setExecutor(new EconomyCommand());
        this.getCommand("pay").setExecutor(new PayCommand());
    }

    public void onDisable() {
        vaultHook.unhook();
    }
    
    public File getBalanceFile() {

        File balanceFile = new File(this.getDataFolder() + File.separator, "Balance.yml");
        return balanceFile;
    }
}
