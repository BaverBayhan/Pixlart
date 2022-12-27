package com.pixl.CollabArt.controller;
import com.pixl.CollabArt.model.Pixel;
import com.pixl.CollabArt.model.PixelRequest;
import com.pixl.CollabArt.service.CanvasService;
import com.pixl.CollabArt.service.PixelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Canvas")
public class CanvasController {

    @Autowired
    CanvasService canvasService;
    @Autowired
    PixelService pixelService;

    @GetMapping()
    public Pixel getMatchedPixel(@RequestBody PixelRequest pixelRequest) {
        return pixelService.getPixelByPosition(pixelRequest.getHorizontal_pos(),pixelRequest.getVertical_pos());

    }

    @GetMapping("/{id2}")
    public String generateCanvas(@PathVariable long id)
    {
        return "sevval";
    }
}
