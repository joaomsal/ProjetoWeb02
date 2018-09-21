package visao;

import controle.curriculoDAO;
import controle.disciplinaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curriculo;
import modelo.Disciplina;



@WebServlet(name = "upGrade", urlPatterns = {"/upGrade"})
public class upGrade extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String curso = request.getParameter("curso");
        curriculoDAO d = new curriculoDAO();
        System.out.println(curso);
        ArrayList<Disciplina> disciplinas = d.getDisciplinas(curso);
        ArrayList<Disciplina> disciplinas1 = new disciplinaDAO().getDisciplinas();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upGrade</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"grade.css\">");
            out.println("</head>");
            out.println("<body>");
             out.println("<form action='GradeCurricular?curso="+curso+"' method='POST' >"
                    + "<button class='home'>VOLTAR</button></form>"
                    + "<form>"
                    + "<div class = 'sec'>"
                    + " <section id = 'up' class = 'sct'> "
                    + " <h2>EDIÇÃO</h2>"
                    + "CÓDIGO<div>" + "<select class = 'select' name = 'upC'>"
                    + "<option value='-'>SELECIONE UMA DISCIPLINA</option>");
            for (int i = 0; i < disciplinas.size(); i++) {
                out.println("<option value ='" + disciplinas.get(i).getCod() + "' >" + disciplinas.get(i).getCod() + " - "+disciplinas.get(i).getNome()+"</option>");
            }

            out.println("</select>" + "</div>"
                    + "<input type='hidden' value='" + curso + "' name= 'curso'/>"
                    + "PERIODO<div><input type='text' name='upP' placeholder='EX: Nº DE 1-10'/></div>"
                    + "TIPO<div><input type='text' name='upT' placeholder='EX: (O) PARA OBRIGATÓRIA E (C) PARA COMPLEMENTAR'/></div>"
                    + "<div class='bta'>"
                    + "<button type='submit' onclick='up()'>EDITAR DISCIPLINA</button>"
                    + " \n</section>  </div>"
                    + "</form>");
            out.println("</body>");
            out.println("</html>");
            request.setCharacterEncoding("UTF-8");
            out.println("<script language = 'JavaScrpit' >");
            out.println("function up(){");
            Curriculo c2 = new Curriculo();
            c2.setDisc(request.getParameter("upC").toUpperCase());
            c2.setTipo_disc(request.getParameter("upT"));
            c2.setPeriodo(Integer.parseInt(request.getParameter("upP")));
            c2.setCurso(request.getParameter("curso"));
            d.upDisciplina(c2);

            out.println("}</script>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
