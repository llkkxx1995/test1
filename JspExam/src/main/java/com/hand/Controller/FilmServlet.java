package com.hand.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.pojo.Film;
import com.hand.pojo.Language;
import com.hand.service.FilmServiceImp;
import com.hand.service.UserServiceImp;

import freemarker.ext.beans.BooleanModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FilmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserServiceImp userService = new UserServiceImp();
	private FilmServiceImp filmService = new FilmServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
           
		//���ñ���
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if (type==null||type.equals("query")) {
			this.query(request, response);
		}else if (type.equals("delete")) {
			this.delete(request, response);
		}else if(type.equals("add")){
			this.add(request, response);
		}else if(type.equals("text")){
			this.text(request, response);
		}else if (type.equals("update")) {
		    this.update(request, response);	
		}
	}
	
	//��ѯ��Ӱ������
	protected void query (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Language> languages = filmService.queryLanguages();
		request.setAttribute("languages", languages);
		
		List<Film> films = filmService.queryFilms();
		request.setAttribute("films", films);
		request.getRequestDispatcher("film.jsp").forward(request, response);;
		
	}
	
	//ɾ����Ӱ������
protected void delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String film_id_str = request.getParameter("film_id");
		int film_id = Integer.parseInt(film_id_str);
		
		boolean result = filmService.deleteFilm(film_id);
		if (result) {
			request.setAttribute("result", "ɾ���ɹ�");
		}else{
			request.setAttribute("result", "ɾ��ʧ��");
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}


//��ӵ�Ӱ
protected void add (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
	String lan = request.getParameter("language");
    int language = Integer.parseInt(lan);
    
    boolean result = filmService.addFilm(name, desc, language);
    if (result) {
		request.setAttribute("result", "��Ӱ��ӳɹ�");
	}else{
		request.setAttribute("result", "��Ӱ���ʧ��");
	}
    request.getRequestDispatcher("result.jsp").forward(request, response);
}


protected void  text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String film_id_str = request.getParameter("film_id");
	int film_id = Integer.parseInt(film_id_str);
	Film film = filmService.queryFilmById(film_id);
	request.setAttribute("film", film);
	System.out.println(film);

	request.getRequestDispatcher("fmk.ftl").forward(request, response);
	  
}



//���µ�Ӱ
protected void  update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map map = request.getParameterMap();
	Set ketSet = map.keySet();
	Iterator iter = ketSet.iterator();
	while(iter.hasNext()){
		Object key = iter.next();
		Object value = map.get(key);
		System.out.println("key==>"+key+"  value==>"+value);
	}
	
	
	String idStr = request.getParameter("id");
	int id = Integer.parseInt(idStr);
	String title = request.getParameter("title");
	String desc = request.getParameter("desc");
	String language = request.getParameter("language");
	
	Film film = new Film();
	film.setFilm_id(id);
	film.setName(language);
	film.setDescription(desc);
	film.setTitle(title);
	
	boolean reuslt = filmService.updateFilm(film);
	if (reuslt) {
		request.setAttribute("result", "�޸ĳɹ�");
	}else{
		request.setAttribute("result", "�޸�ʧ��");
	}
	request.getRequestDispatcher("result.jsp").forward(request, response);
	
}

}
