package me.gl1tchcraft.economy.methods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.gl1tchcraft.economy.Main;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class EconomyImplementer implements Economy {

    private Main plugin = Main.getInstance;
    
    File balanceFile = plugin.getBalanceFile();
	FileConfiguration balances = YamlConfiguration.loadConfiguration(balanceFile);

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public int fractionalDigits() {
        return 0;
    }

    @Override
    public String format(double v) {
        return null;
    }

    @Override
    public String currencyNamePlural() {
        return null;
    }

    @Override
    public String currencyNameSingular() {
        return null;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        UUID uuid = offlinePlayer.getUniqueId();
    	if(balances.get(uuid + ".Balance") == null) {
    		return false;
    	} else {
    		return true;
    	}
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {
        UUID uuid = offlinePlayer.getUniqueId();
        double balance = balances.getDouble(uuid + ".Balance");
        return balance;
    }
    
    public boolean setBalance(OfflinePlayer offlinePlayer, double v)  {
    	UUID uuid = offlinePlayer.getUniqueId();
    	balances.set(uuid + ".Balance", v);
    	try {
			balances.save(balanceFile);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double v) {
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String s, double v) {
        return false;
    }


    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double v) {
    	UUID uuid = offlinePlayer.getUniqueId();
    	double balance = balances.getDouble(uuid + ".Balance");
    	balances.set(uuid + ".Balance", balance - v);
    	try {
			balances.save(balanceFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
    	UUID uuid = offlinePlayer.getUniqueId();
    	double balance = balances.getDouble(uuid + ".Balance");
    	balances.set(uuid + ".Balance", balance + v);
    	try {
			balances.save(balanceFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }

    @Override
    public EconomyResponse createBank(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse deleteBank(String s) {
        return null;
    }

    @Override
    public EconomyResponse bankBalance(String s) {
        return null;
    }

    @Override
    public EconomyResponse bankHas(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse bankWithdraw(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse bankDeposit(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public List<String> getBanks() {
        return null;
    }


    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
    	UUID uuid = offlinePlayer.getUniqueId();
    	balances.set(uuid + ".Balance", 0.0);
    	try {
			balances.save(balanceFile);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    }

	@Override
	public boolean createPlayerAccount(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createPlayerAccount(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getBalance(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(OfflinePlayer arg0, String arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean has(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean has(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}
}