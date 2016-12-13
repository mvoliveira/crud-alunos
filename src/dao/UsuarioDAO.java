/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author francisco
 */
public class UsuarioDAO {
    private Connection connection;
    int id;
    String nome;
    String cpf;
    String email;
    String telefone;
    
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Usuario aluno){
        String sql = "insert into aluno(nome, endereço, telefone) values(?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
//            stmt.setString(2, aluno.getDataNascimento());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getTelefone());
            stmt.execute();
            stmt.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public List retornaUsuarios(){
        List lista = new ArrayList();
        String sql = "select * from aluno";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                lista.add(rs.getString(2));

            }
            rs.close();
            stmt.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return lista;
    }
   
    public List buscaNome(String nome){
        List lista = new ArrayList();
        String sql = "select * from aluno where nome like ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                lista.add(rs.getString(2));
            }
            rs.close();
            stmt.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return lista;
    }

    public Usuario buscaUsuario(String nome){
        Usuario usuario = new Usuario();
        String sql = "select * from aluno where nome = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString(2));
//                usuario.setDataNascimento(rs.getString(3));
                usuario.setEndereco(rs.getString(3));
                usuario.setTelefone(rs.getString(4));

                usuario.setMedia(rs.getFloat(9));
                usuario.setNota1(rs.getFloat(5));
                usuario.setNota2(rs.getFloat(6));
                usuario.setNota3(rs.getFloat(7));
                usuario.setNota4(rs.getFloat(8));
            }else{
            JOptionPane.showMessageDialog(null, "Nenhum usuario selecionado!" );
            }
            rs.close();
            stmt.close();
            
            }catch(SQLException u){
                throw new RuntimeException(u);
            }
            return usuario;
        }
    
    public void Remove(String id){//excluir pelo id que é chave primaria
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja remover este aluno?", "confirmaçao", JOptionPane.OK_CANCEL_OPTION);
        if(resposta == JOptionPane.OK_OPTION){
            String sql = "delete from aluno where id = ?";
            try{
            PreparedStatement stmt = connection.prepareStatement(sql);//variavel com conexao com o banco de dados
            stmt.setString(1, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Aluno removido com sucesso!");
            }catch(SQLException u){ //catch é o erro casos nao consiga a remocao
                throw new RuntimeException(u);
            }
       }
    }
    
    public void Alterar(Usuario aluno){
    int resposta = JOptionPane.showConfirmDialog(null, "Deseja salvar estas notas?", "confirmaçao", JOptionPane.OK_CANCEL_OPTION);
       if(resposta == JOptionPane.OK_OPTION){
       String sql = "update aluno set nota1= ?, nota2 = ?, nota3 = ?, nota4= ?, media=? where id = ?";
           try{
               PreparedStatement stmt = connection.prepareStatement(sql);//variavel com conexao com o banco de dados
               stmt.setString(1, Float.toString(aluno.getNota1()));
               stmt.setString(2, Float.toString(aluno.getNota2()));
               stmt.setString(3, Float.toString(aluno.getNota3()));
               stmt.setString(4, Float.toString(aluno.getNota4()));
               stmt.setString(5, Float.toString(aluno.getMedia()));
               stmt.setString(6, Integer.toString(aluno.getId()));
               stmt.execute();
               stmt.cancel();
               JOptionPane.showMessageDialog(null,"Notas Salva com Sucesso!");
           }catch(SQLException u){ //catch é o erro casos nao consiga a remocao
                throw new RuntimeException(u);
           }
       }
       
    }  
      
}
    
  
    


