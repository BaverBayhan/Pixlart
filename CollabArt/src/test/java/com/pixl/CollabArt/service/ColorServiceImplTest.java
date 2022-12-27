package com.pixl.CollabArt.service;

import com.pixl.CollabArt.model.Color;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ColorServiceImplTest {
    @Autowired
    private ColorService service;

    @Test
    void saveColor() {
        Color color = new Color(255,255,255);
        service.saveColor(color);
    }

    @Test
    void updateColor() {
        Color newColor = new Color(112,112,112);
        service.updateColor(2,newColor);
    }

    @Test
    void getColorById() {
        service.getColorById(1);
    }

    @Test
    void deleteColorById() {
        service.deleteColorById(2);
    }

    @Test
    void containsColor()
    {
        Color color = new Color(14,5,0);
        System.err.println(service.contains_color(color));
    }

    @Test
    void addColors()
    {
        service.addDefaultColorPallet();
    }

}