package at.keppi.gothiccraft.services;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.RegistryObject;

public class SoundService {

    public static void play(RegistryObject<SoundEvent> sound, Entity entity) {
        entity.playSound(sound.get(), 1F, 1F);
    }
}
