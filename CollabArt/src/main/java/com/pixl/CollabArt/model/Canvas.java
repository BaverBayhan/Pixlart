package com.pixl.CollabArt.model;
import jakarta.persistence.*;

@Entity
@Table(name="canvas")
public class Canvas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name="horizontal_start")
    int horizontal_pos_start;
    @Column(name="vertical_start")
    int vertical_pos_start;
    @Column(name="horizontal_length")
    int horizontal_pos_length;
    @Column(name="vertical_length")
    int vertical_pos_length;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "first_pixel_id",referencedColumnName = "id")
    Pixel pixel;

    public Canvas() {

    }

    public Canvas(int horizontal_pos_start, int vertical_pos_start, int horizontal_pos_length, int vertical_pos_length) {
        this.horizontal_pos_start = horizontal_pos_start;
        this.vertical_pos_start = vertical_pos_start;
        this.horizontal_pos_length = horizontal_pos_length;
        this.vertical_pos_length = vertical_pos_length;
    }

    public long getId() {
        return id;
    }

    public int getHorizontal_pos_start() {
        return horizontal_pos_start;
    }

    public void setHorizontal_pos_start(int horizontal_pos_start) {
        this.horizontal_pos_start = horizontal_pos_start;
    }

    public int getVertical_pos_start() {
        return vertical_pos_start;
    }

    public void setVertical_pos_start(int vertical_pos_start) {
        this.vertical_pos_start = vertical_pos_start;
    }

    public int getHorizontal_pos_length() {
        return horizontal_pos_length;
    }

    public void setHorizontal_pos_length(int horizontal_pos_length) {
        this.horizontal_pos_length = horizontal_pos_length;
    }
    public int getVertical_pos_length() {
        return vertical_pos_length;
    }

    public void setVertical_pos_length(int vertical_pos_length) {
        this.vertical_pos_length = vertical_pos_length;
    }

    public Pixel getPixel() {
        return pixel;
    }

    public void setPixel(Pixel pixel) {
        this.pixel = pixel;
    }

    @Override
    public String toString() {
        return "Canvas{" +
                "id=" + id +
                ", horizontal_pos_start=" + horizontal_pos_start +
                ", vertical_pos_start=" + vertical_pos_start +
                ", horizontal_pos_length=" + horizontal_pos_length +
                ", vertical_pos_length=" + vertical_pos_length +
                ", pixel=" + pixel +
                '}';
    }
}
