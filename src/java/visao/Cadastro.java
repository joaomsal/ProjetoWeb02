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


@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        disciplinaDAO d = new disciplinaDAO();
        ArrayList<Disciplina> disciplinas = d.getDisciplinas();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
             out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"cadastro.css\">");
            out.println("<title>CADASTRO DE DISCIPLINAS</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("	<form action='Cadastro'>\n" +
"	<div>	<div class= 'cont'>\n" +
"			CÓDIGO <div><input name=\"codigo\" type=\"text\" placeholder='EX: COMP100'/></div>\n" +
"			NOME <div><input name=\"nome\" type=\"text\"/ placeholder='EX: PRGRAMAÇÃO 1'></div>\n" +
"			CARGA HORÁRIA <div><input name=\"carga\" type=\"text\"/ placeholder='EX: 4'></div>\n" +
"			PRÉ-REQUISITO 1 <div><select class = 'select' name= 'pq1'>"
                    + "<option value='-'> SELECIONE UM PRÉ-REQUISITO</option>");
                   for(int i = 0; i< disciplinas.size();i++){
                       out.println("<option value ='"+disciplinas.get(i).getCod()+"' >"+disciplinas.get(i).getCod()+"</option>");
                   } 
            out.println("</select></div>");
            out.println("PRÉ-REQUISITO 2 <div>"
                    + "<select class = 'select' name = 'pq2'>"
                    + "<option value='-'> SELECIONE UM PRÉ-REQUISITO</option>");
                   for(int i = 0; i< disciplinas.size();i++){
                       out.println("<option value ='"+disciplinas.get(i).getCod()+"' >"+disciplinas.get(i).getCod()+"</option>");
                   } 
                   
            out.println("</select>"+
"			<div><button type=\"submit\" onclick='cadastro()'>ENVIAR</button></div>\n" +
"	</div>	</div>\n" +
"	</form>");
            out.println("</body>");
            request.setCharacterEncoding("UTF-8");
            out.println("<script language = 'JavaScrpit'charset='UTF-8'>"
                    + "function cadastro(){\n");
            Disciplina d1 = new Disciplina();
            d1.setCod(request.getParameter("codigo").toUpperCase());
            d1.setNome(request.getParameter("nome"));
            d1.setCrd(Integer.parseInt(request.getParameter("carga")));
            if(request.getParameter("pq1").equals("-")){
               // deixa null 
            }else{
            d1.setPq1(request.getParameter("pq1"));}
            if(request.getParameter("pq2").equals("-")){
                // deixa null
            }else{
            d1.setPq2(request.getParameter("pq2"));}
            out.println("if("+d.addDisciplina(d1)+"){\n "+
                " alert('Salvo com sucesso!'); \n"+
           " } else{"+
                " alert('Erro ao salvar');}\n ");
   
                    out.println( " }</script>");

        out.println("</html>");
    
    }}

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
