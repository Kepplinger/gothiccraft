package at.keppi.gothiccraft.services;

import at.keppi.gothiccraft.entities.MusicTickableSoundInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

public class MusicService {

    private static MusicTickableSoundInstance currentMusic = null;

    public static boolean playMusic(RegistryObject<SoundEvent> sound) {
        MusicTickableSoundInstance music = new MusicTickableSoundInstance(sound.get());

        if (currentMusic == null || !currentMusic.getLocation().getPath().equals(music.getLocation().getPath())) {
            getSoundManager().play(music);

            if (currentMusic != null) {
                currentMusic.fadeOut();
                playTransition(40);
            }

            currentMusic = music;
            return true;
        }

        return false;
    }

    public static void playTransition(int delayTicks) {
        RegistryObject<SoundEvent> transitionSound = BiomeMusicFacade.getTransition();
        SimpleSoundInstance transitionSoundInstance = SimpleSoundInstance.forMusic(transitionSound.get());
        getSoundManager().playDelayed(transitionSoundInstance, delayTicks);
    }

    private static MusicManager getMusicManager() {
        return Minecraft.getInstance().getMusicManager();
    }

    private static SoundManager getSoundManager() {
        return Minecraft.getInstance().getSoundManager();
    }
}
