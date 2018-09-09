package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Curso;


public class cursoDAO {
    private Connection con = null;
    
    public cursoDAO(){
        con = new Conexao().Conect();
    }
    
    public ArrayList<Curso> getCursos(){
        ArrayList<Curso> cursos = new ArrayList();
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT codigo, nome FROM curso");
                while (rs.next()){
                    Curso c = new Curso();
                    c.setCod(rs.getString("codigo"));
                    c.setNome(rs.getString("nome"));
                    cursos.add(c);
                }
                return cursos;
        } catch (SQLException ex) {
            System.out.println("ERRO: "+ ex);
        }
        return cursos;
    }
}
