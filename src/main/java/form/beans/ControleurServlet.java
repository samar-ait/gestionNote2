package form.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mod.sco.Scolarite;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Scolarite sco = new Scolarite();
		NoteForm nf = new NoteForm();
		nf.setNum_Ins(request.getParameter("num_Ins"));
		nf.setLesNotes(sco.getNotes(nf.getNum_Ins()));
		
		HttpSession session = request.getSession();
		session.setAttribute("nf",nf); 
		// Add some debugging output
	    System.out.println("Num Inscription: " + nf.getNum_Ins());
	    System.out.println("Number of Notes: " + nf.getLesNotes().size());
		response.sendRedirect("Notes.jsp");
		
		
		
	}

}
