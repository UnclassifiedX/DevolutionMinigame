package it.dado997.Devolution;

import it.dado997.Devolution.Commands.AdminCommands.AdminCommandManager;
import it.dado997.Devolution.Commands.CommandManager;
import it.dado997.Devolution.Events.*;
import it.dado997.Devolution.Events.Weapons.*;
import it.dado997.Devolution.Files.ArenaFile;
import it.dado997.Devolution.Files.Messages;
import it.dado997.Devolution.Files.PlayerDataStore;
import it.dado997.Devolution.Game.Arena;
import it.dado997.Devolution.Locations.GlobalLobby;
import it.dado997.Devolution.Signs.SignEditor;
import it.dado997.Devolution.Signs.SignHandler;
import it.dado997.Devolution.Utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    public static Main instance;

    public static int version = getIntVersion()[0];
    public static int release = getIntVersion()[1];

    public void onEnable() {
        instance = this;

        Messages.loadMessages();
        ArenaFile.getInstance();
        PlayerDataStore.getInstance();
        SignEditor.getInstance();
        GlobalLobby.getInstance();
        this.getCommand("devolution").setExecutor(new CommandManager());
        this.getCommand("devolutionadmin").setExecutor(new AdminCommandManager());
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerStatusHandler(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new RestrictionHandler(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerLeaveArenaChecker(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new SignHandler(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerDeath(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerDevolution(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerDamage(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerGetHit(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new ItemDrop(), (Plugin) this);
        this.getServer().getPluginManager().registerEvents((Listener)new CreeperWeapon(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new BlazeWeapon(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new SpiderWeapon(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new SlimeWeapon(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new GolemWeapon(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new ChickenWeapon(), (Plugin)this);
        final File arenasfolder = new File(this.getDataFolder() + File.separator + "arenas");
        arenasfolder.mkdirs();
        this.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new Runnable() {
            @Override
            public void run() {
                GlobalLobby.getInstance().loadFromConfig();
                for (final String file : arenasfolder.list()) {
                    final Arena arena = new Arena(file.substring(0, file.length() - 4));
                    arena.getStructureManager().loadFromConfig();
                    arena.getStatusManager().enableArena();
                    ArenaFile.getInstance().registerArena(arena);
                }
                SignEditor.getInstance().loadConfiguration();
            }
        }, 20L);

        getServer().getConsoleSender().sendMessage(ChatUtil.format("&4<< &9Devolution &aEnabled &4>>"));

        if (Bukkit.getPluginManager().getPlugin("Vault") != null) {
            return;
        } else {
            Main.getInstance().getLogger().warning("Vault not detected, money rewards disabled!");
        }

        Updater updater = new Updater(this, 80650);

        try {
            if(updater.checkForUpdates()) {
                this.getServer().getConsoleSender().sendMessage(ChatUtil.format("&4<< &9Devolution &4>> &cThe updater find an update."));
            }else{
                this.getServer().getConsoleSender().sendMessage(ChatUtil.format("&4<< &9Devolution &4>> &aThe plugin is up to date."));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onDisable() {
        instance = null;

        getServer().getConsoleSender().sendMessage(ChatUtil.format("&4<< &9Devolution &cDisabled &4>>"));
    }

    public static String getServerVersion() {
        String pkg = Bukkit.getServer().getClass().getPackage().getName();
        String version = pkg.substring(pkg.lastIndexOf('.') + 1);

        return version;
    }

    public static int[] getIntVersion() {
        int version = Integer.valueOf(Bukkit.getServer().getClass().getName().split("\\.")[3].split("_")[1]);
        int release = Integer.valueOf(Bukkit.getServer().getClass().getName().split("\\.")[3].split("R")[1]);
        int[] v =  {version, release};

        return v;
    }

    public static Main getInstance() {
        return instance;
    }

}
