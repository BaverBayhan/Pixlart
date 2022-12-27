package com.pixl.CollabArt.repository;

import com.pixl.CollabArt.model.Pixel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PixelRepositoryTest {
    @Autowired
    PixelRepository repository;

    @Test
    void findPixelTest()
    {
        Pixel pixel = repository.findPixel(1000,2000);
        System.out.println(pixel.toString());
    }

    @Test
    void findLargestId()
    {
        System.err.println(repository.findTopByOrderByIdDesc().getId());
    }
}