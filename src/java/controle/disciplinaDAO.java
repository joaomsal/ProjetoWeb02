package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Curriculo;
import modelo.Disciplina;

public class disciplinaDAO {

    private Connection con = null;

    public disciplinaDAO() {
        con = new Conexao().Conect();
    }


    public ArrayList<Disciplina> getDisciplinas() {
        ArrayList<Disciplina> disciplinas = new ArrayList();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT codigo, nome, creditos, preq1, preq2 FROM disciplina");
            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setCod(rs.getString("codigo"));
                d.setNome(rs.getString("nome"));
                d.setCrd(rs.getInt("creditos"));
                d.setPq1(rs.getString("preq1"));
                d.setPq2(rs.getString("preq2"));
                disciplinas.add(d);
            }
            return disciplinas;
        } catch (SQLException ex) {
            System.out.println("ERRO : " + ex);
        }
        return disciplinas;
    }

    public boolean addDisciplina(Disciplina d) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO disciplina (codigo,nome,creditos, preq1,preq2) VALUES (?,?,?,?,?)");
            ps.setString(1, d.getCod());
            ps.setString(2, d.getNome());
            ps.setInt(3, d.getCrd());
            ps.setString(4, d.getPq1());
            ps.setString(5, d.getPq2());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
            return false;
        }
    }


    public boolean delDisciplina(String cod) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM disciplina WHERE codigo = ?");
            ps.setString(1, cod);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
            return false;
        }
    }
    
    public boolean upDisciplina(Disciplina d){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE disciplina SET  nome = ?, creditos = ? , preq1 = ?, preq2 = ? WHERE codigo = ?");
            ps.setString(1, d.getNome());
            ps.setInt(2, d.getCrd());
            ps.setString(3, d.getPq1());
            ps.setString(4, d.getPq2());
            ps.setString(5, d.getCod());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO: "+ex);
            return false;
        }
    }

}
