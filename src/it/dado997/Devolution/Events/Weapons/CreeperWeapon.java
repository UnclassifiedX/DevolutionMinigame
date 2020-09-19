package it.dado997.Devolution.Events.Weapons;

import it.dado997.Devolution.Files.ArenaFile;
import it.dado997.Devolution.Files.Messages;
import it.dado997.Devolution.Game.Arena;
import it.dado997.Devolution.Main;
import it.dado997.Devolution.Utils.ChatUtil;
import it.dado997.Devolution.Utils.CountDown.WeaponsCountDown;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MiscDisguise;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CreeperWeapon implements Listener {

    Arena arena;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        Arena arena = ArenaFile.getInstance().getPlayerArena(player.getName());

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (arena != null) {
                if (arena.getPlayerHandler().getCreeper().contains(player)) {
                    if (arena.getPlayerHandler().getCanShot().contains(player)) {
                        if (player.getItemInHand().getType() == Material.SULPHUR) {
                            Fireball fireball = player.launchProjectile(Fireball.class);
                            fireball.setIsIncendiary(false);
                            MiscDisguise miscDisguise = new MiscDisguise(DisguiseType.DROPPED_ITEM, Material.SULPHUR, 0);
                            DisguiseAPI.disguiseToAll(fireball, (miscDisguise).setViewSelfDisguise(false));
                            arena.getPlayerHandler().getCanShot().remove(player);
                            new WeaponsCountDown(player, arena).runTaskTimer(Main.getInstance(), 0L, 20L);
                            player.sendMessage(ChatUtil.format(Messages.abilityused));
                        }
                    } else {
                        player.sendMessage(ChatUtil.format(Messages.abilitynotavaible));
                    }
                }
            }
        }
    }
}
