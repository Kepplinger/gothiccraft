package at.keppi.gothiccraft.services;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.registries.RegistryObject;

public class MusicService {

    private static Music currentMusic = null;
    private static Music previousMusic = null;

    public static boolean play(RegistryObject<SoundEvent> sound) {
        Music music = new Music(sound.get(), 0, 0, true);

        if (currentMusic == null || !currentMusic.getEvent().getLocation().getPath().equals(music.getEvent().getLocation().getPath())) {
            getMusicManager().startPlaying(music);

            if (currentMusic != null) {
                previousMusic = currentMusic;
            }

            currentMusic = music;
            return true;
        } else {
            return false;
        }
    }

    public static void stopPreviousMusic() {
        if (previousMusic != null) {
            ResourceLocation musicLocation = previousMusic.getEvent().getLocation();
            System.out.println("Stop previous music: " + musicLocation);
            getSoundManager().stop(musicLocation, SoundSource.MUSIC);
            previousMusic = null;
        }
    }

    private static MusicManager getMusicManager() {
        return Minecraft.getInstance().getMusicManager();
    }

    private static SoundManager getSoundManager() {
        return Minecraft.getInstance().getSoundManager();
    }
}
