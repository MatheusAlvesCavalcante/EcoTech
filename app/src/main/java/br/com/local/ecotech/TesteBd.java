package br.com.local.ecotech;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.sql.Connection;
public class TesteBd extends AppCompatActivity {
    TextView BancoTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_bd);

        Connection conn = ConexaoBD.conectar(TesteBd.this);
        BancoTeste = findViewById(R.id.BancoTeste);
        try {
            if (conn != null) {
                if (!conn.isClosed()) BancoTeste.setText("CONEXAO REALIZADA COM SUCESSO");
                else
                    BancoTeste.setText("A CONEXÃO ESTÁ FECHADA");
            } else {
                BancoTeste.setText("CONEXÃO NULA NÃO REALIZADA");
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            BancoTeste.setText("CONEXÃO FALHOU!!!\n" + ex.getMessage());
        }
    }
}