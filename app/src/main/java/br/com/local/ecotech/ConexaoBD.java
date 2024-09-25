package br.com.local.ecotech;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
     /*
    Método de conexao com SQL SERVER
    Local ou
    Nuvem no somee.com
     */

    public static Connection conectar() {
        //Objeto de conexao
        Connection conn = null;
        try {
//            Adicionar Política de criacao de thread
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // >>>>>>>>>>>>>> Conexão com SQL Server Local <<<<<<<<<<<<<<
            conn= DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.2.233;"+
                    "databaseName=myCafeteria2f;user=sa;password=@ITB123456;");
            System.out.println("Conectado com sucesso ao SQL Server local!");

        } catch (SQLException e) { // SQLException

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}