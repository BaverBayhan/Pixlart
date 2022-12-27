package com.pixl.CollabArt.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name="color")
public class Color {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	long id;
	@Column(name="red", nullable = false)
	int red;
	@Column(name="green",nullable = false)
	int green;
	@Column(name="blue",nullable = false)
	int blue;

	public Color() {
		red=0;
		green=0;
		blue=0;
	}
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public long getId() {
		return id;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	@Override
	public String toString() {
		return "Color{" +
				"id=" + id +
				", red=" + red +
				", green=" + green +
				", blue=" + blue +
				'}';
	}

	@JsonIgnore
	public int[] getColorInfo()
	{
		return new int[]{this.red,this.green,this.blue};
	}

	public boolean equals(Color color)
	{
		return this.red == color.red && this.blue == color.blue && this.green == color.green;
	}

}
