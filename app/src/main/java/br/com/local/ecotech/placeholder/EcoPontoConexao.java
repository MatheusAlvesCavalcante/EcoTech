package br.com.local.ecotech.placeholder;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.local.ecotech.ConexaoBD;

public class EcoPontoConexao {


    public static List<EcoPontoModel> pesquisarEcoPontos(Context context) {
        List<EcoPontoModel> ecoPontos = new ArrayList<>();
        try {
            PreparedStatement pst = ConexaoBD.conectar().prepareStatement(
                    "select bairro, nome, foto, cep, logradouro, numResid, telefone, horarioFunc from EcoPonto where statusPonto = 1");

            ResultSet res = pst.executeQuery();

            while (res.next()) {
                ecoPontos.add(new EcoPontoModel(
                        res.getString("bairro"),
                        res.getString("nome"),
                        res.getBytes("foto"),
                        res.getString("cep"),
                        res.getString("logradouro"),
                        res.getString("numResid"),
                        res.getString("telefone"),
                        res.getString("horarioFunc")
                ));
            }

        } catch (SQLException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return ecoPontos;
    }





    public static List<EcoPontoModel> pesquisarEcoPontos(int tipoResiduo, String cidade, Context context){
        List<EcoPontoModel> ecoPontos = new ArrayList<>();
        try{
            PreparedStatement pst =
                    ConexaoBD.conectar().prepareStatement("select bairro, nome, foto, cep, logradouro, numResid, telefone, horarioFunc from EcoPonto where gruporesiduo_id = ? and cidade = ? and statusPonto = 1");

            pst.setInt(1, tipoResiduo);
            pst.setString(2, cidade);

            ResultSet res = pst.executeQuery();

            while (res.next()) {
                ecoPontos.add(new EcoPontoModel(
                        res.getString("bairro"),
                        res.getString("nome"),
                        res.getBytes("foto"),
                        res.getString("cep"),
                        res.getString("logradouro"),
                        res.getString("numResid"),
                        res.getString("telefone"),
                        res.getString("horarioFunc")
                ));
            }

        }catch(SQLException e){
            Toast.makeText(context, e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        return  ecoPontos;
    }
}
