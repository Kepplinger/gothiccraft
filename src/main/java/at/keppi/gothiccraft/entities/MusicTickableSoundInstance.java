package at.keppi.gothiccraft.entities;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class MusicTickableSoundInstance extends AbstractTickableSoundInstance {

    public static final int FADE_DURATION = 40;
    private float fade = FADE_DURATION;
    private boolean fadeOut = false;

    public MusicTickableSoundInstance(SoundEvent soundEvent) {
        super(soundEvent, SoundSource.MUSIC);
    }

    @Override
    public void tick() {
        if (this.fadeOut) {
            this.fade--;

            if (this.fade >= 0) {
                System.out.println("Music is fading out: " + this.fade);
                this.volume = Math.max(0.0F, Math.min(this.fade / FADE_DURATION, 1.0F));
            } else {
                this.stop();
            }
        }
    }

    public void fadeOut() {
        this.fadeOut = true;
    }

    @Override
    public boolean canStartSilent() {
        return super.canStartSilent();
    }

    @Override
    public boolean canPlaySound() {
        return super.canPlaySound();
    }
}
