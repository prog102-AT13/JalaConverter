package org.fundacion.jala.converter.view.converter;

public class FrameVideo {
    private String name="F";
    private double frame;

    public FrameVideo(double frame) {
        this.name = name;
        this.frame = frame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFrame() {
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
