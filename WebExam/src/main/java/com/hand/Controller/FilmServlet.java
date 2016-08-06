package com.hand.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.pojo.Film;
import com.hand.pojo.Language;
import com.hand.service.FilmServiceImp;
import com.hand.service.UserServiceImp;

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
           
		//设置编码
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
	
	//查询电影的请求
	protected void query (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Language> languages = filmService.queryLanguages();
		request.setAttribute("languages", languages);
		
		List<Film> films = filmService.queryFilms();
		request.setAttribute("films", films);
		request.getRequestDispatcher("film.jsp").forward(request, response);;
		
	}
	
	//删除电影的请求
protected void delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String film_id_str = request.getParameter("film_id");
		int film_id = Integer.parseInt(film_id_str);
		
		boolean result = filmService.deleteFilm(film_id);
		if (result) {
			request.setAttribute("result", "删除成功");
		}else{
			request.setAttribute("result", "删除失败");
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}


//添加电影
protected void add (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
	String lan = request.getParameter("language");
    int language = Integer.parseInt(lan);
    
    boolean result = filmService.addFilm(name, desc, language);
    if (result) {
		request.setAttribute("result", "电影添加成功");
	}else{
		request.setAttribute("result", "电影添加失败");
	}
    request.getRequestDispatcher("result.jsp").forward(request, response);
}


protected void  text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String film_id_str = request.getParameter("film_id");
	int film_id = Integer.parseInt(film_id_str);
	Film film = filmService.queryFilmById(film_id);
	request.setAttribute("film", film);
	System.out.println(film);
	
	  Configuration cfg = new Configuration();  
	  Map root = new HashMap();  
	  root.put("film", film);  
	  Template t = cfg.getTemplate("/WEB-INF/fmk.ftl");  
	  response.setCharacterEncoding("utf-8");  
	  try {  
		   t.process(root, response.getWriter());  
		  } catch (TemplateException e) {  
		   // TODO Auto-generated catch block  
		   e.printStackTrace();  
		  }  
	  
}



//更新电影
protected void  update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	
}

}
