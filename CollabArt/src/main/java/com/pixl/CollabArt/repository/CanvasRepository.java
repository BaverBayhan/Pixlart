package com.pixl.CollabArt.repository;
import com.pixl.CollabArt.model.Canvas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanvasRepository extends JpaRepository<Canvas,Long> {

}
