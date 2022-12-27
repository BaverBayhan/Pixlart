package com.pixl.CollabArt.repository;
import com.pixl.CollabArt.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {
    @Query(value = "SELECT*FROM color c WHERE c.blue=:blue AND c.green=:green AND c.red=:red", nativeQuery = true )
    Color findColor(@Param("red") int red , @Param("green") int green , @Param("blue") int blue);
}
