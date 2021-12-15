package com.mycompany.funcao_consultar;

import java.sql.ResultSet;
import javax.swing.*;

public class consulta extends javax.swing.JFrame {
    
    MySql mysql;
    
    public consulta() {
        initComponents();
        //
        mysql = new MySql();
        //
        // Só faltou a senha do banco 'labprat' para completar a função de conexão.
        //
        // Se tiver problemas para compilar, mudando o valor de <maven.compiler.source> e <maven.compiler.target> 
        // em Project Files/pom.xml para 15 pode resolver o problema.
        //
        int conexao = mysql.conectar("localhost", "3306", "labprat", "root", "senha_do_banco");
        if (conexao == 1){
            System.out.println("Banco de dados conectado");
        }
        else if(conexao == 0) {
            System.out.println("Não foi possível estabelecer comunicação com o banco de dados");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        caixa_de_selecao = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        caixa_de_texto = new javax.swing.JTextField();
        botao_de_confirmacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Consultar informações de projeto");

        caixa_de_selecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome do projeto", "Nome do solicitante", "Nome do professor", "Prazo de entrega" }));
        caixa_de_selecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixa_de_selecaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecione por qual informação deseja procurar o projeto:");

        caixa_de_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixa_de_textoActionPerformed(evt);
            }
        });

        botao_de_confirmacao.setText("Procurar");
        botao_de_confirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_de_confirmacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(caixa_de_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(caixa_de_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botao_de_confirmacao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(caixa_de_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caixa_de_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(botao_de_confirmacao)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caixa_de_selecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixa_de_selecaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixa_de_selecaoActionPerformed

    private void caixa_de_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixa_de_textoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixa_de_textoActionPerformed

    private void botao_de_confirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_de_confirmacaoActionPerformed

      String informacao =  caixa_de_texto.getText();
      String metodo = caixa_de_selecao.getSelectedItem().toString();
      
      if("ID".equals(metodo)){
          metodo = "ID";
      }
      if("Nome do professor".equals(metodo)){
          metodo = "nome_professor";
      }
      if("Nome do solicitante".equals(metodo)){
          metodo = "nome_solicitante";
      }
      if("Nome do projeto".equals(metodo)){
          metodo = "nome_projeto";
      }
      if("Prazo de entrega".equals(metodo)){
          metodo = "prazo_entrega";
      }
      //
      ResultSet rs = mysql.consultar("SELECT * FROM projetos WHERE " + metodo + "='" + informacao + "'");
      //
      if (rs != null) {
          try {
              while (rs.next()) {
                 
                  JOptionPane.showMessageDialog(null, "Encontrado projeto:\n" + "ID: " + rs.getString("ID") + 
                          "\n" + "Nome do projeto: " + rs.getString("nome_projeto") +
                          "\n" + "Descricao: " + rs.getString("descricao") + 
                          "\n" + "Nome do professor: " + rs.getString("nome_professor") + 
                          "\n" + "Nome do solicitante: " + rs.getString("nome_solicitante") + 
                          "\n" + "Prazo de entrega: " + rs.getString("prazo_entrega"));

              }
          } catch (Exception e) {}
      } 
    }//GEN-LAST:event_botao_de_confirmacaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_de_confirmacao;
    private javax.swing.JComboBox<String> caixa_de_selecao;
    private javax.swing.JTextField caixa_de_texto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
