package com.hand.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.hand.Dao.FilmDao;
import com.hand.pojo.Film;
import com.hand.pojo.Language;
import com.hand.utils.DatabaseObject;


public class FilmDaoImp implements FilmDao {

	public List<Film> queryFilms(Connection con) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select film_id,title,description,name from film,language"
				+ " where film.language_id = language.language_id";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Film> films = new DatabaseObject<Film>(rs, Film.class).getObjectList();
		rs.close();
		stmt.close();
		return films;
	}

	public int deleteFilm(Connection con, int film_id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from film where film_id = ?";
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setInt(1, film_id);
		int result = ptmt.executeUpdate();
		ptmt.close();
		return result;
	}

	public List<Language> queryLanguages(Connection con) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from language";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Language> languages = new DatabaseObject<Language>(rs, Language.class).getObjectList();
		rs.close();
		stmt.close();
		return languages;
	}

	public int addFilm(Connection con, String name, String desc, int lan) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "insert into film(title,description,language_id) values(?,?,?)";
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setString(1, name);
	    ptmt.setString(2, desc);
	    ptmt.setInt(3, lan);
	    int result = ptmt.executeUpdate();
	    ptmt.close();
		return result;
	}

	public Film queryFilmById(Connection con, int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select film_id,title,description,name from film,language where film.language_id = language.language_id and film_id = ?";
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		Film film = new DatabaseObject<Film>(rs, Film.class).getObject();
		rs.close();
		ptmt.close();
		return film;
	}

	public int updateFilm(Connection con, Film film) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update film set title = ?,description=? where film_id=?";
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setString(1, film.getTitle());
		ptmt.setString(2, film.getDescription());
		ptmt.setInt(3, film.getFilm_id());
		int result = ptmt.executeUpdate();
		ptmt.close();
		return result;
	}

}
