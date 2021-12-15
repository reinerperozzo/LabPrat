package com.mycompany.funcao_consultar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySql {
    private Connection c;

    public Connection getConnection() {
        return c;
    }

    public int conectar(String IP, String porta, String database, String usuario, String senha) {
        int conexao = 0;
        try {
            String url = "jdbc:mysql://" + IP + ":" + porta + "/" + database + "?user=" + usuario + "&password=" + senha;
            System.out.println(url);
            c = (Connection) DriverManager.getConnection(url);
            conexao = 1;
        } catch (Exception e) {
        }
        return conexao;
    }

    public ResultSet consultar(String query) {
        ResultSet rs = null;
        try {
            Statement st = (Statement) c.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
        }
        return rs;
    }
}