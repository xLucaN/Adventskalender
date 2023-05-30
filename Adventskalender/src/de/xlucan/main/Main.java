package de.xlucan.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    static File file = new File("plugins//System//Adventskalender//data.yml");
    static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    static File config = new File("plugins//System//Adventskalender//config.yml");
    static YamlConfiguration configcfg = YamlConfiguration.loadConfiguration(config);

    public static String Prefix = "�bPvPArea �8| �a";

    @Override
    public void onEnable() {
        getCommand("adventskalender").setExecutor(new AdventskalenderCMD());
        Bukkit.getPluginManager().registerEvents(new AdventskalenderCMD(), this);
        File folder = new File("plugins///System//Adventskalender");
        if(!folder.exists()){
            folder.mkdir();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!config.exists()){
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Prefix = configcfg.getString("Prefix").replace("&", "�");
        }
        configcfg.options().copyDefaults(true);
        configcfg.addDefault("Prefix", "&bPvPArea &8| &a");
        configcfg.addDefault("RewardMSG", "&aDu erh�lst deine Belohnung aus dem %day%. T�rchen");
        configcfg.addDefault("AlreadyEarned", "&cDu hast das heutige T�rchen bereits ge�ffnet");
        configcfg.addDefault("NotCurrentDay", "&cDieser Tag ist heute nicht");
        configcfg.addDefault("Reward.1", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.2", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.3", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.4", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.5", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.6", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.7", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.8", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.9", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.10", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.11", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.12", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.13", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.14", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.15", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.16", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.17", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.18", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.19", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.20", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.21", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.22", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.23", "give %player% minecraft:diamond 1");
        configcfg.addDefault("Reward.24", "give %player% minecraft:diamond 1");
        try {
            configcfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ItemStack createItem(Material material, int anzahl, int subid, String displayname)
    {
        short neuesubid = (short)subid;
        ItemStack i = new ItemStack(material, anzahl, neuesubid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayname);
        i.setItemMeta(m);

        return i;
    }

    public static void setUsed(String UUID, int Day){
        cfg.set(UUID+".day"+Day, true);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean hasUsed(String UUID, int Day){
        if(cfg.getString(UUID+".day"+Day) != null){
            if(cfg.getBoolean(UUID+".day"+Day) == true){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
