package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.President;
import data.PresidentDAO;
import data.PresidentFileDAO;

public class PresidentServlet extends HttpServlet {
	private PresidentDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new PresidentFileDAO(getServletContext());
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String next = req.getParameter("next");
		String back = req.getParameter("back");
		String id = req.getParameter("id");
		System.out.println(next);
		System.out.println(id);
		if(next!=null){
			System.out.println("next" + next);
			System.out.println("id" + id);
			String term = Integer.parseInt(id) + 1 + "";
			if( term.equals("46")){
				term="1";
			}
			President p = dao.getTerm(term);
			System.out.println(p);
			req.setAttribute("president", p);
			req.setAttribute("presList", dao.getAllPresidents());
			req.getRequestDispatcher("/select.jsp").forward(req, resp);
		}
		else if (back!=null){
			System.out.println("back" + back);
			System.out.println("id" + id);
			String term = Integer.parseInt(id) - 1 + "";
			if( term.equals("0")){
				term="45";
			}
			President p = dao.getTerm(term);
			System.out.println(p);
			req.setAttribute("president", p);
			req.setAttribute("presList", dao.getAllPresidents());
			req.getRequestDispatcher("/select.jsp").forward(req, resp);
		}
		else if (id!=null){
			President p = dao.getTerm(id);
			System.out.println(p);
			req.setAttribute("president", p);
			req.setAttribute("presList", dao.getAllPresidents());
			req.getRequestDispatcher("/select.jsp").forward(req, resp);
		}else{ 
		req.setAttribute("presList", dao.getAllPresidents());
		req.getRequestDispatcher("/firstPage.jsp").forward(req, resp);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("president");
		String party = req.getParameter("party");
		String term = req.getParameter("term");
		String next = req.getParameter("next");
		String id = req.getParameter("id");
		System.out.println(name);
		System.out.println(party);

		if (name != null) {
			System.out.println("pres by name");
			President p = dao.getTerm(name);
			System.out.println(p);
			req.setAttribute("president", p);
			req.setAttribute("presList", dao.getAllPresidents());
			req.getRequestDispatcher("/select.jsp").forward(req, resp);
		} else if (party != null) {

			System.out.println("pres by party");
			List<President> p = dao.getParty(party);
			System.out.println(p);
			req.setAttribute("presidentList", p);
			req.setAttribute("presList", dao.getAllPresidents());
			req.getRequestDispatcher("/select.jsp").forward(req, resp);
		} else if (term != null) {
			System.out.println("pres by term");
			President p = dao.getTerm(term);
			System.out.println(p);
			req.setAttribute("president", p);
			req.setAttribute("presList", dao.getAllPresidents());
			req.getRequestDispatcher("/select.jsp").forward(req, resp);
		}  else if (next != null) {
			
		} else {
			req.getRequestDispatcher("/error.jsp").forward(req, resp);

		}
		
		

	}

}