package com.pixl.CollabArt;

import com.pixl.CollabArt.service.ColorService;
import com.pixl.CollabArt.service.ColorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollabArtApplication {
	public static void main(String[] args) {
		SpringApplication.run(CollabArtApplication.class, args);
	}

}
