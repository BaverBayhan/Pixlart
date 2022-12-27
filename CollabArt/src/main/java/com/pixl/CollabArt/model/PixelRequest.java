package com.pixl.CollabArt.model;

public class PixelRequest {
    int horizontal_pos;
    int vertical_pos;


    public PixelRequest(int horizontal_pos, int vertical_pos) {
        this.horizontal_pos = horizontal_pos;
        this.vertical_pos = vertical_pos;
    }

    public int getHorizontal_pos() {
        return horizontal_pos;
    }

    public void setHorizontal_pos(int horizontal_pos) {
        this.horizontal_pos = horizontal_pos;
    }

    public int getVertical_pos() {
        return vertical_pos;
    }

    public void setVertical_pos(int vertical_pos) {
        this.vertical_pos = vertical_pos;
    }

    @Override
    public String toString() {
        return "PixelRequest{" +
                "horizontal_pos=" + horizontal_pos +
                ", vertical_pos=" + vertical_pos +
                '}';
    }
}
