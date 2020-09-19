package it.dado997.Devolution.Events;

import it.dado997.Devolution.Files.ArenaFile;
import it.dado997.Devolution.Files.Messages;
import it.dado997.Devolution.Game.Arena;
import it.dado997.Devolution.Main;
import it.dado997.Devolution.Utils.ChatUtil;
import it.dado997.Devolution.Utils.CountDown.DevolutionCountDown;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class PlayerDevolution implements Listener {

    @EventHandler
    public void devolutionEvent(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        final Arena arena = ArenaFile.getInstance().getPlayerArena(player.getName());

        if (arena != null) {
            if (!arena.getPlayerHandler().getPlayersDevoluting().contains(player) && arena.getPlayerHandler().getPlayersCanDevolute().contains(player)) {
                if (!player.isSneaking()) {
                    player.sendTitle(ChatUtil.format(Messages.devolutetitle), "");
                }
                if (player.isSneaking()) {
                    arena.getPlayerHandler().getPlayersDevoluting().add(player);
                    new DevolutionCountDown(player.getPlayer(), arena).runTaskTimer(Main.getInstance(), 0L, 20L);
                }
            }
        }
    }


}
