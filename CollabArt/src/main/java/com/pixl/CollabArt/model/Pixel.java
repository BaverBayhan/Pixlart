package com.pixl.CollabArt.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="pixel")
public class Pixel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name="VP")
    int vertical_pos;
    @Column(name="HP")
    int horizontal_pos;

    @ManyToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id",referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Color color;

    public Pixel() {

    }
    public Pixel(int horizontal_pos, int vertical_pos, Color color) {
        this.vertical_pos = vertical_pos;
        this.horizontal_pos = horizontal_pos;
        this.color=color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVertical_pos() {
        return vertical_pos;
    }

    public void setVertical_pos(int vertical_pos) {
        this.vertical_pos = vertical_pos;
    }

    public int getHorizontal_pos() {
        return horizontal_pos;
    }

    public void setHorizontal_pos(int horizontal_pos) {
        this.horizontal_pos = horizontal_pos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pixel{" +
                "id=" + id +
                ", vertical_pos=" + vertical_pos +
                ", horizontal_pos=" + horizontal_pos +
                ", color=" + color +
                '}';
    }
}
