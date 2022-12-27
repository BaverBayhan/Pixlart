package com.pixl.CollabArt.repository;
import com.pixl.CollabArt.model.Pixel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PixelRepository extends JpaRepository<Pixel,Long> {
    @Query(value = "SELECT*FROM pixel u WHERE u.hp=:hp AND u.vp=:vp", nativeQuery = true)
    Pixel findPixel(@Param("hp") int horizontal_pos, @Param("vp") int vertical_pos);
    Pixel findTopByOrderByIdDesc();
}