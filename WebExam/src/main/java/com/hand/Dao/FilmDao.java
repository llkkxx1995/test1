package com.hand.Dao;

import java.sql.Connection;
import java.util.List;
import com.hand.pojo.Film;
import com.hand.pojo.Language;

public interface FilmDao {
	public List<Film> queryFilms(Connection con)throws Exception;
	
	public int deleteFilm(Connection con,int film_id)throws Exception;
	
	public List<Language> queryLanguages(Connection con)throws Exception;
	
	public int addFilm(Connection con,String name,String desc,int lan)throws Exception;

	public Film queryFilmById(Connection con,int id)throws Exception;
	
	public int updateFilm(Connection con,Film film)throws Exception;
}
