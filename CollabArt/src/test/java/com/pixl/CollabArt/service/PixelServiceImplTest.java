package com.pixl.CollabArt.service;

import com.pixl.CollabArt.model.Color;
import com.pixl.CollabArt.model.Pixel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PixelServiceImplTest {
    @Autowired
    PixelService pixelService;
    @Autowired
    ColorService colorService;
    @Test
    void savePixel() {
        Color color = new Color(256,256,256);
        Pixel pixel = new Pixel(-1,-1,color);
        pixelService.savePixel(pixel);
    }
    @Test
    void updatePixelColor() {
        Color color = new Color(1,1,1);
        Color newColor = new Color(5,5,5);
        Pixel pixel = new Pixel(0,12,color);
        pixelService.updatePixelColor(pixel,newColor);
    }

    @Test
    void getPixelByPositionTest()
    {
        Pixel pixel = pixelService.getPixelByPosition(1000,2000);
        System.err.println(pixel);
    }
}