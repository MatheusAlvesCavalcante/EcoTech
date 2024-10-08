package br.com.local.ecotech.placeholder;

import android.content.Context;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.local.ecotech.ConexaoBD;

public class EcoPontoConexao {

    public static List<EcoPontoModel> pesquisarEcoPontos(Context context){
        List<EcoPontoModel> ecoPontos = new ArrayList<>();
        try{
            PreparedStatement pst =
                    ConexaoBD.conectar().prepareStatement("select bairro, nome from EcoPonto");

            ResultSet res = pst.executeQuery();

            while(res.next()){
                ecoPontos.add(new EcoPontoModel(
                        res.getString(1),
                        res.getString(2)
                ));
            }

        }catch(SQLException e){
            Toast.makeText(context, e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        return  ecoPontos;
    }
}