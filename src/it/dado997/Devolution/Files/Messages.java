package it.dado997.Devolution.Files;

import it.dado997.Devolution.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Messages {

    public static String nopermission;
    public static String teleporttolobby;
    public static String availablearenas;
    public static String arenawolrdna;
    public static String arenadisabled;
    public static String arenarunning;
    public static String arenaregenerating;
    public static String arenavehicle;
    public static String arenadisabling;
    public static String playerscountinarena;
    public static String limitreached;
    public static String playerjoinedtoplayer;
    public static String playerjoinedtoothers;
    public static String playerlefttoplayer;
    public static String playerlefttoothers;
    public static String playervotedforstart;
    public static String arenastarted;
    public static String arenacountdown;
    public static String arenafinished;
    public static String lobbynotset;
    public static String playerwontoplayer;
    public static String playerdeathtoplayer;
    public static String playerdeathtoothers;
    public static String playerwonbroadcast;
    public static String playerrewardmessage;
    public static String invalidcommand;
    public static String devoluting;
    public static String devolutewaiting;
    public static String cannotmovewhiledevoluting;
    public static String alreadyingame;
    public static String abilityavaible;
    public static String abilitynotavaible;
    public static String abilityused;
    public static String respawning;
    public static String respawned;
    public static String devolutetitle;

    public static void sendMessage(final Player player, final String message) {
        if (!message.equals("")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public static void broadcastMessage(final String message) {
        if (!message.equals("")) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public static void loadMessages() {
        final File messageconfig = new File(Main.getInstance().getDataFolder(), "Messages.yml");
        final FileConfiguration config = YamlConfiguration.loadConfiguration(messageconfig);
        Messages.nopermission = config.getString("nopermission", Messages.nopermission);
        Messages.teleporttolobby = config.getString("teleporttolobby", Messages.teleporttolobby);
        Messages.availablearenas = config.getString("availablearenas", Messages.availablearenas);
        Messages.arenawolrdna = config.getString("arenawolrdna", Messages.arenawolrdna);
        Messages.arenadisabled = config.getString("arenadisabled", Messages.arenadisabled);
        Messages.arenarunning = config.getString("arenarunning", Messages.arenarunning);
        Messages.arenaregenerating = config.getString("arenaregenerating", Messages.arenaregenerating);
        Messages.arenavehicle = config.getString("arenavehicle", Messages.arenavehicle);
        Messages.arenadisabling = config.getString("arenadisabling", Messages.arenadisabling);
        Messages.playerscountinarena = config.getString("playerscountinarena", Messages.playerscountinarena);
        Messages.limitreached = config.getString("limitreached", Messages.limitreached);
        Messages.playerjoinedtoplayer = config.getString("playerjoinedtoplayer", Messages.playerjoinedtoplayer);
        Messages.playerjoinedtoothers = config.getString("playerjoinedtoothers", Messages.playerjoinedtoothers);
        Messages.playerlefttoplayer = config.getString("playerlefttoplayer", Messages.playerlefttoplayer);
        Messages.playerlefttoothers = config.getString("playerlefttoothers", Messages.playerlefttoothers);
        Messages.playervotedforstart = config.getString("playervotedforstart", Messages.playervotedforstart);
        Messages.arenastarted = config.getString("arenastarted", Messages.arenastarted);
        Messages.arenacountdown = config.getString("arenacountdown", Messages.arenacountdown);
        Messages.arenafinished = config.getString("arenafinished", Messages.arenafinished);
        Messages.playerwontoplayer = config.getString("playerwontoplayer", Messages.playerwontoplayer);
        Messages.playerdeathtoplayer = config.getString("playerdeathtoplayer", Messages.playerdeathtoplayer);
        Messages.playerdeathtoothers = config.getString("playerdeathtoothers", Messages.playerdeathtoothers);
        Messages.playerwonbroadcast = config.getString("playerwonbroadcast", Messages.playerwonbroadcast);
        Messages.playerrewardmessage = config.getString("playerrewardmessage", Messages.playerrewardmessage);
        Messages.invalidcommand = config.getString("invalidcommand", Messages.invalidcommand);
        Messages.devoluting = config.getString("devoluting", Messages.devoluting);
        Messages.devolutewaiting = config.getString("devoluted", Messages.devolutewaiting);
        Messages.cannotmovewhiledevoluting = config.getString("playermovewhiledevoluting", Messages.cannotmovewhiledevoluting);
        Messages.alreadyingame = config.getString("alreadyingame", Messages.alreadyingame);
        Messages.abilityavaible = config.getString("abilityavaible", Messages.abilityavaible);
        Messages.abilitynotavaible = config.getString("abilitynotavaible", Messages.abilitynotavaible);
        Messages.abilityused = config.getString("abilityused", Messages.abilityused);
        Messages.respawning = config.getString("respawning", Messages.respawning);
        Messages.respawned = config.getString("respawned", Messages.respawned);
        Messages.lobbynotset = config.getString("lobbynotset", Messages.lobbynotset);
        Messages.devolutetitle = config.getString("devolutetitle", Messages.devolutetitle);
        saveMessages(messageconfig);
    }

    private static void saveMessages(final File messageconfig) {
        final FileConfiguration config = new YamlConfiguration();
        config.set("nopermission", Messages.nopermission);
        config.set("invalidcommand", Messages.invalidcommand);
        config.set("teleporttolobby", Messages.teleporttolobby);
        config.set("availablearenas", Messages.availablearenas);
        config.set("arenawolrdna", Messages.arenawolrdna);
        config.set("arenadisabled", Messages.arenadisabled);
        config.set("arenarunning", Messages.arenarunning);
        config.set("arenaregenerating", Messages.arenaregenerating);
        config.set("arenavehicle", Messages.arenavehicle);
        config.set("arenadisabling", Messages.arenadisabling);
        config.set("lobbynotset", Messages.lobbynotset);
        config.set("playerscountinarena", Messages.playerscountinarena);
        config.set("limitreached", Messages.limitreached);
        config.set("playerjoinedtoplayer", Messages.playerjoinedtoplayer);
        config.set("playerjoinedtoothers", Messages.playerjoinedtoothers);
        config.set("alreadyingame", Messages.alreadyingame);
        config.set("playerlefttoplayer", Messages.playerlefttoplayer);
        config.set("playerlefttoothers", Messages.playerlefttoothers);
        config.set("playervotedforstart", Messages.playervotedforstart);
        config.set("arenastarted", Messages.arenastarted);
        config.set("arenacountdown", Messages.arenacountdown);
        config.set("arenafinished", Messages.arenafinished);
        config.set("abilityavaible", Messages.abilityavaible);
        config.set("abilitynotavaible", Messages.abilitynotavaible);
        config.set("abilityused", Messages.abilityused);
        config.set("devoluting", Messages.devoluting);
        config.set("devolutewaiting", Messages.devolutewaiting);
        config.set("respawning", Messages.respawning);
        config.set("respawned", Messages.respawned);
        config.set("playermovewhiledevoluting", Messages.cannotmovewhiledevoluting);
        config.set("playerwontoplayer", Messages.playerwontoplayer);
        config.set("playerdeathtoplayer", Messages.playerdeathtoplayer);
        config.set("playerdeathtoothers", Messages.playerdeathtoothers);
        config.set("playerwonbroadcast", Messages.playerwonbroadcast);
        config.set("playerrewardmessage", Messages.playerrewardmessage);
        config.set("devolutetitle", Messages.devolutetitle);
        try {
            config.save(messageconfig);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        Messages.nopermission = "&4You don't have permission to do this";
        Messages.teleporttolobby = "&6Teleported to lobby";
        Messages.availablearenas = "&6Available arenas:&r ";
        Messages.arenawolrdna = "&6Arena world is not loaded";
        Messages.arenadisabled = "&6Arena is disabled";
        Messages.arenarunning = "&6Arena already running";
        Messages.arenaregenerating = "&6Arena is regenerating";
        Messages.arenavehicle = "&6You can't join the game while sitting inside vehicle";
        Messages.arenadisabling = "&6Arena is disabling";
        Messages.playerscountinarena = "&6Current number of players in arena: {COUNT}";
        Messages.limitreached = "&6Slot limit reached.";
        Messages.playerjoinedtoplayer = "&6You joined the arena";
        Messages.playerjoinedtoothers = "&6Player {PLAYER} joined the arena";
        Messages.playerlefttoplayer = "&6You left the arena";
        Messages.playerlefttoothers = "&6Player {PLAYER} left the game";
        Messages.playervotedforstart = "&6You voted for game start";
        Messages.arenastarted = "&6Arena started.";
        Messages.arenacountdown = "&6Arena starts in {COUNTDOWN} seconds";
        Messages.arenafinished = "&6Arena ended.";
        Messages.devoluting = "&a{TIME} seconds remaining before devoluting.";
        Messages.devolutewaiting = "&a{TIME} seconds remaining before re-entry.";
        Messages.playerwontoplayer = "&6You won the game";
        Messages.playerdeathtoplayer = "&6You died.";
        Messages.playerdeathtoothers = "&6Player {PLAYER} was killed by {KILLER}.";
        Messages.playerwonbroadcast = "&9[Devolution] &a{PLAYER}&r won the game on arena &c{ARENA}";
        Messages.playerrewardmessage = "&6You have been rewarded: {REWARD}";
        Messages.invalidcommand = "&cInvalid command!";
        Messages.cannotmovewhiledevoluting = "&cDon't move while devoluting!";
        Messages.alreadyingame = "&cYou are already in game!";
        Messages.abilityavaible = "&aYour ability is ready to use!";
        Messages.abilitynotavaible = "&cYou ability isn't ready to use!";
        Messages.abilityused = "&aYou used your ability!";
        Messages.respawning = "&a{TIME} seconds remaining for respawn.";
        Messages.respawned = "&aRespawned";
        Messages.lobbynotset = "&cLobby not set!";
        Messages.devolutetitle = "&aCrouch To Devolute!";
    }

}
