package com.pixl.CollabArt.service;

import com.pixl.CollabArt.Exception.NoSuchColorItemException;
import com.pixl.CollabArt.model.Color;
import com.pixl.CollabArt.repository.ColorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public void saveColor(Color color) {
        colorRepository.save(color);
    }
    @Override
    public void updateColor(long id, Color newColor) {
        Color color = getColorById(id);
        color.setBlue(newColor.getBlue());
        color.setRed(newColor.getRed());
        color.setGreen(newColor.getGreen());
        colorRepository.save(color);
    }
    @Override
    public Color getColorById(long id) {
        Optional<Color> color = colorRepository.findById(id);
        if(color.isPresent())
        {
            return color.get();
        }
        else
        {
            throw new NoSuchColorItemException();
        }
    }
    @Override
    public void deleteColorById(long id) {
        colorRepository.deleteById(id);
    }
    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }
    @Override
    public boolean contains_color(Color color) {
        Color color1 = colorRepository.findColor(color.getRed(),color.getGreen(),color.getBlue());
        return color1 != null;
    }

    @Override
    public long findColorId(Color color) {
        if(contains_color(color))
        {
            Color color1 = colorRepository.findColor(color.getRed(),color.getGreen(),color.getBlue());
            return color1.getId();
        }
        else
        {
            return 0;
        }
    }
    @Override
    public void addDefaultColorPallet() {
        List<Color> colorList = new ArrayList<>();
        Color color1 = new Color(239,17,11);
        colorList.add(color1);
        Color color2 = new Color(92,3,0);
        colorList.add(color2);
        Color color3 = new Color(253,146,6);
        colorList.add(color3);
        Color color4 = new Color(164,93,0);
        colorList.add(color4);
        Color color5 = new Color(81,173,157);
        colorList.add(color5);
        Color color6 = new Color(254,246,54);
        colorList.add(color6);
        Color color7 = new Color(143,138,0);
        colorList.add(color7);
        Color color8 = new Color(14,253,14);
        colorList.add(color8);
        Color color9 = new Color(0,154,0);
        colorList.add(color9);
        Color color10 = new Color(1,10,251);
        colorList.add(color10);
        Color color11 = new Color(0,6,164);
        colorList.add(color11);
        Color color12 = new Color(186,32,253);
        colorList.add(color12);
        Color color13 = new Color(118,0,168);
        colorList.add(color13);
        Color color14 = new Color(8,15,15);
        colorList.add(color14);
        Color color15 = new Color(250,255,255);
        colorList.add(color15);
        for (Color color : colorList) {
            colorRepository.save(color);
        }
    }
}
