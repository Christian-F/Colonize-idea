package tech.christianfisher.colonize;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class AppPreferences {

    private static final String PREFS_MUSIC_VOLUME = "volume";
    private static final String PREFS_MUSIC_ENABLED = "music.enabled";
    private static final String PREFS_SOUND_ENABLED = "sound.enable";
    private static final String PREFS_SOUND_VOL = "sound";
    private static final String PREFS_NAME = "colonize";

    protected Preferences getPrefs(){
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public boolean isSoundsEffectsEnabled(){
        return getPrefs().getBoolean(PREFS_SOUND_ENABLED, true);
    }

    public void setSoundEffectsEnabled(boolean enabled){
        getPrefs().putBoolean(PREFS_SOUND_ENABLED, enabled);
        getPrefs().flush();
    }

    public float getMusicVolume(){
        return getPrefs().getFloat(PREFS_MUSIC_VOLUME, 0.5F);
    }

    public void setPrefMusicVolume(float volume){
        getPrefs().putFloat(PREFS_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

    public boolean isMusicEnable(){
        return getPrefs().getBoolean(PREFS_MUSIC_ENABLED, true);
    }

    public void setMusicEnable (boolean enabled){
        getPrefs().putBoolean(PREFS_MUSIC_ENABLED, enabled);
        getPrefs().flush();
    }

    public float getSoundEffectsVolume(){
        return getPrefs().getFloat(PREFS_SOUND_VOL, 0.5f);
    }

    public void setSoundEffectsVolume(float volume){
        getPrefs().putFloat(PREFS_SOUND_VOL, volume);
        getPrefs().flush();
    }
}
