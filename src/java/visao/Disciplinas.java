package visao;

import controle.disciplinaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Disciplina;


@WebServlet(name = "Disciplinas", urlPatterns = {"/Disciplinas"})
public class Disciplinas extends HttpServlet {

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
        ArrayList<Disciplina> disciplinas = new disciplinaDAO().getDisciplinas();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"grade.css\">");
            out.println("<title>DISCIPLINAS</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<ul><li id='link-cad'> <a href='#cad'>CADASTRAR</a> </li>"
                    + "<li id='link-up'> <a href='#up'>EDITAR</a> </li>"
                    + "<li id='link-cad'> <a href='#del'>DELETAR</a> </li></ul>");
            
            out.println("<div class= 'div-tab'>"
                    + "<form>"
                    + "<table class='tabela'>"
                    + "<tr>"
                    + "<td class='tit'>CÓDIGO</td>"
                    + "<td class='tit'>NOME</td>"
                    + "<td class='tit'>CARGA HOŔARIA</td>"
                    + "<td class='tit'>PRÉ-REQUISITO 1</td>"
                    + "<td class='tit'>PRÉ-REQUISITO 2</td>"
                    + "</tr>");
            for (int i = 0; i < disciplinas.size(); i++) {
                out.println("<tr class='dt'>"
                        + "<td>" + disciplinas.get(i).getCod() + "</td>"
                        + "<td>" + disciplinas.get(i).getNome() + "</td>"
                        + "<td>" + disciplinas.get(i).getCrd() + "</td>"
                        + "<td>" + disciplinas.get(i).getPq11() + "</td>"
                        + "<td>" + disciplinas.get(i).getPq22() + "</td>"
                        + "</tr>");
            }
            out.println(
                    "</table>"
                    + "</form>"
                    + "</div>");
            out.println("<form method = 'POST' action = 'Cadastro' >"
                    + "<div class = 'sec'>"
                    + "<section id = 'cad' class = 'sct'> "
                    + "<h2>ADIÇÃO</h2>"
                    + "<div class='bta'>"
                    + "<button type='submit' onclick='addGrade'>ADICIONAR DISCIPLINA</button>"
                    + " \n</section> </div>"
                    + "</form>");
            out.println("<form method='POST' action = 'upDisciplinas'>"
                    + "<div class = 'sec'>"
                    + " <section id = 'up' class = 'sct'> "
                    + "<h2>EDIÇÃO</h2>"
                    + "<div class='bta'>"
                    + "<button type='submit' onclick='upGrade'>EDITAR DISCIPLINA</button>"
                    + " \n</section>  </div>"
                    + "</form>");

            out.println("<form action='Disciplinas'>"
                    + "<div class = 'sec'>"
                    + " <section id = 'del' class = 'sct' >"
                    + "<h2>EXCLUSÃO</h2>"
                    + "CÓDIGO<div>" + "<select class = 'select' name = 'disc'>"
                    + "<option value='-'>SELECIONE UMA DISCIPLINA</option>");
            for (int i = 0; i < disciplinas.size(); i++) {
                out.println("<option value ='" + disciplinas.get(i).getCod() + "' >" + disciplinas.get(i).getCod() + 
                        " - "+disciplinas.get(i).getNome()+"</option>");
            }

            out.println("</select>" + "</div>"
//                    + "<input type='hidden' value='" + curso + "' name= 'curso'/>"
                    + "<div class='bta'>"
                    + " <button type='submit' onclick='del1()' >DELETAR DISCIPLINA</button></div>"
                    + "\n</section> </div>"
                    + " </form>");
            out.println("</body>");
            
            // funções javascript
            disciplinaDAO d = new disciplinaDAO();
            request.setCharacterEncoding("UTF-8");
            out.println("<script language = 'JavaScrpit' >");
            out.println("function del1(){ \n del(); \n window.location.reload();}\n"
                    + "function del(){  ");
            d.delDisciplina(request.getParameter("disc").toUpperCase());
            out.println("}</script>");
            
            out.println("</html>");
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
