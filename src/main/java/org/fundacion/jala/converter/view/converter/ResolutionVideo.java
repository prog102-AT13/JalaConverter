package org.fundacion.jala.converter.view.converter;

public class ResolutionVideo {
    private int width;
    private int height;
    private String name;

    ResolutionVideo(String name,int width,int height ){
        this.height=height;
        this.width=width;
        this.name=name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  width+"X"+height+"     "+name;
    }
}
