package org.fundacion.jala.converter.view.converter;

public class FrameVideo {
    private String name="F";
    private int frame;

    public FrameVideo(int frame) {
        this.name = name;
        this.frame = frame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return frame+name;
    }
}
