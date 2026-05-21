import connection.Conexao;
import view.Adocao;
import view.Tipo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){

        JFrame frame = new JFrame("Cadastro para adoção");
        frame.setSize(500, 620);
        frame.setLayout(null);


        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(20, 50, 150, 30);
        frame.add(labelNome);

        JTextField textNome = new JTextField();
        textNome.setBounds(20, 80, 150, 30);
        frame.add(textNome);


        JLabel labelIdade = new JLabel("Idade");
        labelIdade.setBounds(20, 110, 150, 30);
        frame.add(labelIdade);

        JTextField textIdade = new JTextField();
        textIdade.setBounds(20, 140, 150, 30);
        frame.add(textIdade);


        JLabel labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(20, 170, 150, 30);
        frame.add(labelTipo);

        JComboBox<Tipo> textTipo = new JComboBox(Tipo.values());
        textTipo.setBounds(20, 200, 150, 30);
        frame.add(textTipo);


        JLabel labelRaca = new JLabel("Raça");
        labelRaca.setBounds(20, 230, 150, 30);
        frame.add(labelRaca);

        JTextField textRaca = new JTextField();
        textRaca.setBounds(20, 260, 150, 30);
        frame.add(textRaca);


        JLabel labelEndereco = new JLabel("Endereço");
        labelEndereco.setBounds(20, 290, 150, 30);
        frame.add(labelEndereco);

        JTextField textEndereco = new JTextField();
        textEndereco.setBounds(20, 320, 150, 30);
        frame.add(textEndereco);


        JLabel labelTelefone = new JLabel("Telefone");
        labelTelefone.setBounds(20, 350, 150, 30);
        frame.add(labelTelefone);

        JTextField textTelefone = new JTextField();
        textTelefone.setBounds(20, 380, 150, 30);
        frame.add(textTelefone);


        JButton enviar = new JButton("Enviar");
        enviar.setBounds(20, 440, 150, 30);
        frame.add(enviar);

        enviar.addActionListener(e -> {

            String nome = textNome.getText();
            String idade = textIdade.getText();
            String tipo = textTipo.getSelectedItem().toString();
            String raca = textRaca.getText();
            String endereco = textEndereco.getText();
            String telefone = textTelefone.getText();

            String sql = "INSERT INTO adotar(nome, idade, tipo, raca, endereco, telefone) VALUES (?,?,?,?,?,?)";

            try{
                Connection conexao = Conexao.conectar();
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);
                ps.setString(2, idade);
                ps.setString(3, tipo);
                ps.setString(4, raca);
                ps.setString(5, endereco);
                ps.setString(6, telefone);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!!");
                ps.close();
                conexao.close();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


        frame.setVisible(true);
    }
}
