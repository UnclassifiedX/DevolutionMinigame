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
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.concurrent.TimeUnit;

public class BlazeWeapon implements Listener {

    //public static int counter;
    Arena arena;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) throws InterruptedException {
        Player player = e.getPlayer();

        Arena arena = ArenaFile.getInstance().getPlayerArena(player.getName());

        Vector vector;

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (arena != null) {
                if (arena.getPlayerHandler().getBlaze().contains(player)) {
                    if (arena.getPlayerHandler().getCanShot().contains(player)) {
                        if (player.getItemInHand().getType() == Material.BLAZE_ROD) {
                            vector = player.getEyeLocation().getDirection();
                            MiscDisguise miscDisguise = new MiscDisguise(DisguiseType.DROPPED_ITEM, Material.BLAZE_POWDER, 0);
                            //while (counter < 4) {
                                SmallFireball fireball = player.launchProjectile(SmallFireball.class, vector);
                                fireball.setVelocity(fireball.getVelocity().multiply(1.2D));
                                DisguiseAPI.disguiseToAll(fireball, (miscDisguise).setViewSelfDisguise(false));
                                //counter++;
                                //Thread.sleep(50);
                            //}

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
