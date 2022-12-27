package com.pixl.CollabArt.service;

import com.pixl.CollabArt.model.Color;

import java.util.List;

public interface ColorService {
     void saveColor(Color color);
     void updateColor(long id,Color newColor);
     Color getColorById(long id);
     void deleteColorById(long id);
     List<Color> getAllColors();
     boolean contains_color(Color color);
     long findColorId(Color color);

     void addDefaultColorPallet();


}
