package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Curriculo;
import modelo.Disciplina;

public class curriculoDAO {

    private Connection con = null;

    public curriculoDAO() {
        con = new Conexao().Conect();
    }

    public boolean addDisciplina(Curriculo c) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO curriculo(curso, disciplina ,periodo,tipo_disciplina) VALUES (?,?,?,?)");
            ps.setString(1, c.getCurso());
            ps.setString(2, c.getDisc());
            ps.setInt(3, c.getPeriodo());
            ps.setString(4, c.getTipo_disc());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
            return false;
        }
    }

    public ArrayList<Disciplina> getDisciplinas(String curso) {
        ArrayList<Disciplina> disciplinas = new ArrayList();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT periodo, codigo, nome, creditos,preq1, preq2, tipo_disciplina FROM curriculo INNER JOIN disciplina ON (disciplina = codigo) WHERE curso = '" + curso + "'");
            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setPeriodo(rs.getInt("periodo"));
                d.setCod(rs.getString("codigo"));
                d.setNome(rs.getString("nome"));
                d.setCrd(rs.getInt("creditos"));
                d.setPq1(rs.getString("preq1"));
                d.setPq2(rs.getString("preq2"));
                d.setTipo(rs.getString("tipo_disciplina"));
                disciplinas.add(d);
            }
            return disciplinas;
        } catch (SQLException ex) {
            System.out.println("ERRO 1: " + ex);
        }
        return disciplinas;
    }

    public boolean upDisciplina(Curriculo d) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE curriculo SET  periodo = ?, tipo_disciplina = ?  WHERE disciplina = ? AND curso = ?");

            ps.setInt(1, d.getPeriodo());
            ps.setString(2, d.getTipo_disc());
            ps.setString(3, d.getDisc());
            ps.setString(4, d.getCurso());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
            return false;
        }
    }

    public boolean delDisciplina(String cod, String curso) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM curriculo WHERE disciplina = ? AND curso = ?");
            ps.setString(1, cod);
            ps.setString(2, curso);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
            return false;
        }
    }

}
