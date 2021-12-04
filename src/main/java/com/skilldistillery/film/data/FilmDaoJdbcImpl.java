package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Service
public class FilmDaoJdbcImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private final String user = "student";
	private final String pass = "student";

	public FilmDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT film.id, film.title, film.description, film.release_year, film.rating, language.name FROM film JOIN language ON language.id = film.language_id WHERE film.id = ?;";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setReleaseYear(rs.getString("film.release_year"));
				film.setLanguageName(rs.getString("language.name"));
				film.setRating(rs.getString("film.rating"));
				film.setActors(findActorsByFilmId(filmId));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, actorId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actor;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT actor.id, actor.first_name, actor.last_name FROM film_actor JOIN actor ON actor.id = film_actor.actor_id JOIN film ON film_actor.film_id = film.id WHERE film_actor.film_id = ?;";
			stmt = conn.prepareStatement(sqltxt);

			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		Film film = null;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT film.id, film.title, film.description, film.release_year, film.rating, language.name FROM film JOIN language ON language.id = film.language_id WHERE title LIKE ? OR description LIKE ?;";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getString("film.release_year"));
				film.setLanguageName(rs.getString("language.name"));
				film.setRating(rs.getString("rating"));
				int id = film.getId();
				film.setActors(findActorsByFilmId(id));
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		int uc;
		Film movie = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			sqltxt = "INSERT INTO film (title, description, release_year, language_id, rating ) VALUES" + "(?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sqltxt, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setString(3, film.getReleaseYear());
			stmt.setString(4, film.getLanguageId());
			stmt.setString(5, film.getRating());
			uc = stmt.executeUpdate();
			System.out.println(uc + " film record created.");
			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int filmId = rs.getInt(1);
				film.setId(filmId);
				System.out.println("New film ID: " + filmId);
				movie = film;
			}
			conn.commit();

			// do we need to close still?
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error during inserts");
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
		return movie;
	}

	@Override
	public void deleteFilm(Film film) {
		Connection conn = null;
		String sqltxt;
		PreparedStatement stmt;
		int updateCount;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			sqltxt = "DELETE FROM film WHERE film.id = ?";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();

			conn.commit();
			System.out.println("Film id: " + film.getId() + " has been deleted");

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error during delete");
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updateFilm(Film film) {
		Connection conn = null;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		int uc;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			sqltxt = "UPDATE film SET title=?, description=?, release_year=?, rating=? ";
			stmt = conn.prepareStatement(sqltxt, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setString(3, film.getReleaseYear());
			stmt.setString(4, film.getRating());
			uc = stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();

			conn.commit();

			// do we need to close still?
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error during Update");
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
	}

}
