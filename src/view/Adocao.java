package view;

import connection.Conexao;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Adocao extends JFrame{

    public void criarJanela(){
        JFrame frame = new JFrame("Tela de Cadastro");
        frame.setSize(300, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBackground(Color.BLACK);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(20,30,150,40);

        JTextField nome = new JTextField();
        nome.setBounds(20,60,250,40);

        JLabel labelIdade = new JLabel("Idade");
        labelIdade.setBounds(20,110,150,40);

        JTextField idade = new JTextField();
        idade.setBounds(20,140,250,40);

        JLabel labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(20,180,150,40);

        JTextField tipo = new JTextField();
        tipo.setBounds(20,210,250,40);

        JLabel labelRaca = new JLabel("Raça");
        labelRaca.setBounds(20,250,150,40);

        JTextField raca = new JTextField();
        raca.setBounds(20,290,250,40);

        JLabel labelEndereco = new JLabel("Endereço");
        labelEndereco.setBounds(20,330,150,40);

        JTextField endereco = new JTextField();
        endereco.setBounds(20,360,250,40);

        JLabel labelTelefone = new JLabel("Telefone");
        labelTelefone.setBounds(20,400,150,40);

        JTextField telefone = new JTextField();
        telefone.setBounds(20,430,250,40);

        JButton enviar = new JButton("Enviar");
        enviar.setBounds(65, 490, 150, 40);

        frame.add(labelNome);
        frame.add(nome);

        frame.add(labelIdade);
        frame.add(idade);

        frame.add(labelTipo);
        frame.add(tipo);

        frame.add(labelRaca);
        frame.add(raca);

        frame.add(labelEndereco);
        frame.add(endereco);

        frame.add(labelTelefone);
        frame.add(telefone);

        frame.add(enviar);

        enviar.addActionListener(e -> {
            String sql = "INSERT INTO adotar(nome, idade, tipo, raca, endereco, telefone) VALUES (?, ?, ?, ?, ?, ?)";

            String nomeAnimal = labelNome.getText();
            String idadeAnimal = labelIdade.getText();
            String tipoAnimal = labelTipo.getText();
            String racaAnimal = labelRaca.getText();
            String enderecoAnimal = labelEndereco.getText();
            String telefoneAnimal = labelTelefone.getText();

            try{
                // Conexão com o Banco

                Connection conexao = Conexao.conectar();
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nomeAnimal);
                ps.setString(2, idadeAnimal);
                ps.setString(3, tipoAnimal);
                ps.setString(4, racaAnimal);
                ps.setString(5, enderecoAnimal);
                ps.setString(6, telefoneAnimal);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");

                ps.close();
                conexao.close();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        frame.setVisible(true);
    }
}
