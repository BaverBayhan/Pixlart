package com.pixl.CollabArt.service;

import com.pixl.CollabArt.model.Color;
import com.pixl.CollabArt.model.Pixel;
import jakarta.transaction.Transactional;

public interface PixelService {
    void savePixel(Pixel pixel);
    void updatePixelColor(Pixel pixel, Color newColor);
    boolean contains_pixel(Pixel pixel);
    Pixel getPixelById(long id);

    Pixel getPixelByPosition(int horizontal_position , int vertical_position);
}
