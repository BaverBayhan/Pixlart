package com.pixl.CollabArt.service;
import com.pixl.CollabArt.Exception.NoSuchCanvasElementException;
import com.pixl.CollabArt.model.Canvas;
import com.pixl.CollabArt.model.Color;
import com.pixl.CollabArt.model.Pixel;
import com.pixl.CollabArt.repository.CanvasRepository;
import com.pixl.CollabArt.repository.PixelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CanvasServiceImpl implements CanvasService{

    @Autowired
    CanvasRepository canvasRepository;
    @Autowired
    PixelRepository pixelRepository;
    @Autowired
    ColorService colorService;
    @Autowired
    PixelService pixelService;
    public void saveCanvas(Canvas canvas) {
        canvasRepository.save(canvas);
    }
    @Override
    public void deleteCanvas(long id) {
        canvasRepository.deleteById(id);
    }
    @Override
    public void createCanvas(int start_pos_x,int start_pos_y,int h_length, int v_length) {
       Canvas canvas = new Canvas(start_pos_x,start_pos_y,h_length,v_length);
       Color color = new Color(0,0,0);
       colorService.saveColor(color);
       List<Pixel> pixels = new ArrayList<>();
        
       for(int i = start_pos_y;i<start_pos_y+v_length;i++)
       {
           for(int j=start_pos_x;j<start_pos_x+h_length;j++)
           {
               Pixel pixel = new Pixel(i,j,color);
               pixels.add(pixel);
           }
       }
        for (Pixel value : pixels) {
            pixelService.savePixel(value);
        }
        Pixel pixel = pixelRepository.findPixel(start_pos_x,start_pos_y);
        canvas.setPixel(pixel);
        saveCanvas(canvas);
    }
    @Override
    public Canvas getCanvas(long id) {
        Optional<Canvas> canvas = canvasRepository.findById(id);
        if(canvas.isPresent()){return canvas.get();}
        else{throw new NoSuchCanvasElementException();}
    }
    @Override
    public void shuffleColors(long id) {
        Canvas canvas = getCanvas(id);
        long first_pixel_id = canvas.getPixel().getId();
        long last_pixel_id = first_pixel_id + (long) canvas.getHorizontal_pos_length() *canvas.getVertical_pos_length()-1;
        List<Color> colorList = colorService.getAllColors();
        for(long i = first_pixel_id;i<=last_pixel_id;i++)
        {
            Random k = new Random();
            int rand_number=0;
            while(rand_number==0)
            {
                rand_number = k.nextInt(colorList.size());
            }
            Color color = colorList.get(rand_number);
            Pixel pixel = pixelService.getPixelById(i);
            pixelService.updatePixelColor(pixel,color);
        }
    }
}
