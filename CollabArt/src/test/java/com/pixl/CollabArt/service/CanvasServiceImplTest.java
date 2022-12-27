package com.pixl.CollabArt.service;

import com.pixl.CollabArt.model.Canvas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CanvasServiceImplTest {
    @Autowired
    CanvasService service;

    @Test
    void createPixels() {
        service.createCanvas(1000,2000,50,30);
    }

    @Test
    void saveTest()
    {
//        Canvas canvas = new Canvas(1,1,1,1);
//        canvas.setPixel();
    }
    @Test
    void deleteCanvas()
    {
        service.deleteCanvas(2);
    }

    @Test
    void shuffleColorsTest(){
        service.shuffleColors(63);
    }
}