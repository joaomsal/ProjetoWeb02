package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    Connection con = null;

    public Connection Conect() {
        try { // Conexão com o banco criado
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/projeto2", "root", "123");
            if (con != null) {
                System.out.println("CONECTADO");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO" + ex.getMessage());
        }
        return con;
    }

    public void Close() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getLocalizedMessage());
        }
    }

}
