package it.dado997.Devolution.Utils.CountDown;

import it.dado997.Devolution.Game.Arena;

import it.dado997.Devolution.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DevolutionEvent extends BukkitRunnable {

    Player player = null;
    Arena arena = null;

    public DevolutionEvent(Player player, Arena arena) {
        this.player = player;
        this.arena = arena;
    }

    @Override
    public void run() {
        arena.getPlayerHandler().getPlayersDevoluting().remove(player);
        arena.getPlayerHandler().getPlayersCanDevolute().remove(player);
        player.teleport(arena.getStructureManager().getDevolutePoint());
        new Devoluted(player, arena).runTaskTimer(Main.getInstance(), 0L, 20L);
        cancel();
    }

}
