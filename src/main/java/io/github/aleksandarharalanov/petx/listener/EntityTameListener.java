package io.github.aleksandarharalanov.petx.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityTameEvent;

import java.util.ArrayList;
import java.util.List;

import static io.github.aleksandarharalanov.petx.PetX.getPets;

public class EntityTameListener extends EntityListener {
    @Override
    public void onEntityTame(EntityTameEvent event) {
        String ownerUsername = ((Player) event.getOwner()).getName();
        List<String> ownerPets = getPets().getStringList(ownerUsername, new ArrayList<>());

        String petUniqueId = event.getEntity().getUniqueId().toString();
        ownerPets.add(petUniqueId);

        getPets().setProperty(ownerUsername, ownerPets);
        getPets().save();
    }
}
