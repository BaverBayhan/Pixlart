package com.pixl.CollabArt.service;

import com.pixl.CollabArt.model.Canvas;

public interface CanvasService {
    void deleteCanvas(long id);
    void createCanvas(int start_pos_x,int start_pos_y,int h_length, int v_length);
    Canvas getCanvas(long id);
    void shuffleColors(long id);

}
