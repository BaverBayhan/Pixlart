package com.pixl.CollabArt.service;

import com.pixl.CollabArt.Exception.NoSuchPixelException;
import com.pixl.CollabArt.model.Color;
import com.pixl.CollabArt.model.Pixel;
import com.pixl.CollabArt.repository.PixelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PixelServiceImpl implements PixelService {
    @Autowired
    PixelRepository pixelRepository;
    @Autowired
    ColorService colorService;
    @Override
    public void savePixel(Pixel pixel){
        List<Color> allColors = colorService.getAllColors();
        for (Color color : allColors ) {
            if(pixel.getColor().equals(color))
            {
                Pixel newPixel= new Pixel(pixel.getVertical_pos(),pixel.getHorizontal_pos(),color);
                pixelRepository.save(newPixel);
                return;
            }
        }
        colorService.saveColor(pixel.getColor());
        pixelRepository.save(pixel);

    }
    @Override
    public void updatePixelColor(Pixel pixel,Color newColor) {
        if(contains_pixel(pixel) && !(pixel.getColor().equals(newColor)))
        {
            Pixel persisted_pixel = pixelRepository.findPixel(pixel.getHorizontal_pos(), pixel.getVertical_pos());
            persisted_pixel.setColor(newColor);
            if(colorService.contains_color(newColor))
            {
                List<Color> allColors = colorService.getAllColors();
                for (Color color: allColors) {
                    if(color.equals(newColor))
                    {
                        persisted_pixel.setColor(color);
                        pixelRepository.save(persisted_pixel);
                        return;
                    }
                }
            }
            else
            {
                pixelRepository.save(persisted_pixel);
            }
        }
    }
    @Override
    public boolean contains_pixel(Pixel pixel) {
        Pixel pixel1 = pixelRepository.findPixel(pixel.getHorizontal_pos(),pixel.getVertical_pos());
        return pixel1 != null;
    }

    @Override
    public Pixel getPixelById(long id) {
        Optional<Pixel> pixel = pixelRepository.findById(id);
        if(pixel.isPresent()){return pixel.get();}
        else {throw new NoSuchPixelException();}
    }

    @Override
    public Pixel getPixelByPosition(int horizontal_position, int vertical_position) {
        return pixelRepository.findPixel(horizontal_position,vertical_position);
    }


}
