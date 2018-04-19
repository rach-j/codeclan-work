public class Stereo {
    private String name;
    private CDPlayer player;
    private RecordDeck recordDeck;
    private Radio radio;
    private int volume;

    public Stereo(String name) {
        player = new CDPlayer("Panasonic", "P56", 2);
        recordDeck = new RecordDeck("Sony", "S13", 45);
        radio = new Radio("Phillips", "G52");
        this.name = name;
        this.volume = 20;
    }

    public String tuneRadio() {
        return this.radio.tune();
    }

    public String getName(){
        return this.name;
    }

    public String playSongFromCD(String song){
        return this.player.play(song);
    }

    public String playSongFromRecordPlayer(String song){
        return this.recordDeck.play(song);

    }

    public String raiseVolume() {
        this.volume ++;
        return "Volume up by one";

    }

    public int getVolumeOfStereo() {
        return this.volume;
    }

    public String raiseVolumeOfStereo() {
        this.volume ++;
        return "Volume up by 1";
    }

    public String decreaseVolumeOfStereo() {
        if (this.volume > 0) {
            this.volume --;
            return "Volume down by 1";
        }
return "Volume already zero";
    }



}
