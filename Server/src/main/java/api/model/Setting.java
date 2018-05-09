package api.model;

public class Setting {
    private String displaySetting;
    private int audioLevel;

    public String getDisplaySetting() {
        return this.displaySetting;
    }

    public void setDisplaySetting(String displaySetting) {
        this.displaySetting = displaySetting;
    }

    public int getAudioLevel() {
        return this.audioLevel;
    }

    public void setAudioLevel(int audioLevel) {
        this.audioLevel = audioLevel;
    }
}
