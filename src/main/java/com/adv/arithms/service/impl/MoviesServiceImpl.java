package com.adv.arithms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.adv.arithms.dto.MoviesDto;
import com.adv.arithms.service.MoviesService;

@Service(value = "moviesServiceImpl")
public class MoviesServiceImpl implements MoviesService {

	@Override
	public MoviesDto[] getMovies() {
		MoviesDto[] moviesDtos = new MoviesDto[5];
		try {
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish Connection
			Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/movies_db", "root", "ajay");
			// Create Statement
			java.sql.Statement stmt = connection.createStatement();
			// Execute Query
			ResultSet rs = stmt
						.executeQuery("SELECT id, name, director, genre, released_year FROM movies");
			int i = 0;
			// Iterate Resultset
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String director = rs.getString(3);
				String genre = rs.getString(4);
				int releasedYear = rs.getInt(5);

				MoviesDto moviesDto = new MoviesDto();
				moviesDto.setId(id);
				moviesDto.setName(name);
				moviesDto.setDirector(director);
				moviesDto.setGenre(genre);
				moviesDto.setReleasedYear(releasedYear);

				moviesDtos[i++] = moviesDto;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}

		return moviesDtos;
	}

}
