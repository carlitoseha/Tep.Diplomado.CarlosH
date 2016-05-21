/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicablog;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Session;

/**
 *
 * @author chernandez
 */
public class BlogServices {
    public BlogServices() {
        registrarDriver();
    }
    
    /**
     * Metodo para el registro de driver de conexión.
     */
    private void registrarDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection getConexion() {
      String url = "jdbc:h2:tcp://localhost/~/blog"; 
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "sa", "");
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public boolean crearUsuario(Usuario usr){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "insert into usuario(username, nombre, password, administrador, autor) values(?,?,?,?,?)";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, usr.getUsername());
            prepareStatement.setString(2, usr.getNombre());
            prepareStatement.setString(3, usr.getPassword());
            prepareStatement.setString(4, usr.getAdministrador());
            prepareStatement.setString(5, usr.getAutor());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public boolean modificarUsuario(Usuario usr){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "update usuario set nombre = ?, password = ?, administrador =?, autor =? where username = ?)";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, usr.getNombre());
            prepareStatement.setString(2, usr.getPassword());
            prepareStatement.setString(3, usr.getAdministrador());
            prepareStatement.setString(4, usr.getAutor());
            prepareStatement.setString(5, usr.getUsername());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
       
    public boolean borrarUsuario(Usuario usr){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "delete from usuario where username = ?)";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
           
            prepareStatement.setString(1, usr.getUsername());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public Usuario validarUsuario(String username, String password) {
        Usuario usuario = new Usuario();
        
        Connection con = null;        
        try {
            String query = "select * from usuario where username =? and password =?";
            con = getConexion();
            //
            
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            
            ResultSet rs = prepareStatement.executeQuery();
                        
            while(rs.next()){
                usuario.setUsername(rs.getString("username"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setAdministrador(rs.getString("administrador"));
                usuario.setAutor(rs.getString("autor"));
                return usuario;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        usuario = null;
        return usuario;
    }
    
    public boolean crearArticulo(Articulo art){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "insert into articulo(idarticulo, titulo, cuerpo, autor, foto) values(?,?,?,?,?)";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setInt(1, art.getIdarticulo());
            prepareStatement.setString(2, art.getTitulo());
            prepareStatement.setString(3, art.getCuerpo());
            prepareStatement.setString(4, art.getUsername());
            prepareStatement.setString(5, art.getFoto());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public boolean modificarArticulo(Articulo art){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "update articulo set titulo=?, cuerpo=?, foto=? where idarticulo = ?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, art.getTitulo());
            prepareStatement.setString(2, art.getCuerpo());
            prepareStatement.setString(3, art.getFoto());
            prepareStatement.setInt(4, art.getIdarticulo());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public boolean borrarArticulo(int idArticulo){
        boolean ok =false;
        Connection con = null;        
        try {
            
            //Borramos las etiquetas de este articulo
            this.borrarEtiqueta(idArticulo, 0);
            //Borramos los comentarios de este articulo
            this.borrarComentario(idArticulo, 0);
            
            String query = "delete from articulo where idarticulo = ?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            
            prepareStatement.setInt(1, idArticulo);
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
     public List<Articulo> listaArticulos() {
        List<Articulo> lista = new ArrayList<>();
        Connection con = null;        
        try {
            String query = "select * from articulo order by idarticulo desc";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Articulo art = new Articulo();
                art.setIdarticulo(rs.getInt("idarticulo"));
                art.setTitulo(rs.getString("titulo"));
                art.setCuerpo(rs.getString("cuerpo"));
                art.setFecha(rs.getDate("fecha"));
                art.setUsername(rs.getString("autor"));
                art.setFoto(rs.getString("foto"));
                lista.add(art);
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lista;
    }
    
     public List<Articulo> listaArticulosAutor(String autor) {
        List<Articulo> lista = new ArrayList<>();
        Connection con = null;        
        try {
            String query = "select * from articulo where autor =? order by idarticulo desc";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, autor);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Articulo art = new Articulo();
                art.setIdarticulo(rs.getInt("idarticulo"));
                art.setTitulo(rs.getString("titulo"));
                art.setCuerpo(rs.getString("cuerpo"));
                art.setFecha(rs.getDate("fecha"));
                art.setUsername(rs.getString("autor"));
                art.setFoto(rs.getString("foto"));
                lista.add(art);
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lista;
    }
     
     public Articulo getArticulo(int idarticulo) {
        Articulo art = new Articulo();
        Connection con = null;        
        try {
            String query = "select * from articulo where idarticulo =?";
            con = getConexion();
            //
                        
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1, idarticulo);
            ResultSet rs = prepareStatement.executeQuery();
            
            while(rs.next()){
                art.setIdarticulo(rs.getInt("idarticulo"));
                art.setTitulo(rs.getString("titulo"));
                art.setCuerpo(rs.getString("cuerpo"));
                art.setFecha(rs.getDate("fecha"));
                art.setUsername(rs.getString("autor"));
                art.setFoto(rs.getString("foto"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return art;
    }
    
     public int proxArticulo() {
        int maxArticulo = 1;
        Connection con = null;        
        try {
            String query = "select max(idarticulo) as maxArticulo from articulo";
            con = getConexion();
            //
            
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            
            while(rs.next()){
                maxArticulo = rs.getInt("maxArticulo");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return maxArticulo+1;
    }
    
    public boolean crearComentario(Comentario coment){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "insert into comentario(idcomentario, comentario, idarticulo, autor) values(?,?,?,?)";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setInt(1, coment.getIdcomentario());
            prepareStatement.setString(2, coment.getComentario());
            prepareStatement.setInt(3, coment.getIdarticulo());
            prepareStatement.setString(4, coment.getUsername());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public boolean modificarComentario(Comentario coment){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "update comentario set comentario=?, idarticulo =?, autor=? where idcomentario=?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, coment.getComentario());
            prepareStatement.setInt(2, coment.getIdarticulo());
            prepareStatement.setString(3, coment.getUsername());
            prepareStatement.setInt(4, coment.getIdcomentario());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
     public boolean borrarComentario(int idArticulo, int idComentario){
        boolean ok =false;
        String query; 
        PreparedStatement prepareStatement;
         Connection con = null;        
        try {
            con = getConexion();
           //Si el idComentario es mayor que cero, borramos solo el comentario indicado,
           // de lo contrario se borran todos los comentarios de ese articulo
           if (idComentario > 0 )
            {
                query= "delete from comentario where idcomentario = ?";
                prepareStatement = con.prepareStatement(query);
                prepareStatement.setInt(1, idComentario);
            }else{
                query = "delete from comentario where idarticulo=?";
                prepareStatement = con.prepareStatement(query);
                prepareStatement.setInt(1, idArticulo);
            }
               
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public List<Comentario> listaComentarios(int idArticulo) {
        List<Comentario> lista = new ArrayList<>();
        Connection con = null;        
        try {
            String query = "select * from comentario where idarticulo =? order by idcomentario desc";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1, idArticulo);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Comentario coment = new Comentario();
                coment.setIdcomentario(rs.getInt("idcomentario"));
                coment.setComentario(rs.getString("comentario"));
                coment.setAutorcomentario(rs.getString("autor"));
                coment.setIdarticulo(rs.getInt("idarticulo"));
                
                lista.add(coment);
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lista;
    }
    
     public int proxComentario() {
        int maxComentario = 1;
        Connection con = null;        
        try {
            String query = "select max(idcomentario) as maxComentario from comentario";
            con = getConexion();
            //
            
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            
            while(rs.next()){
                maxComentario = rs.getInt("maxComentario");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return maxComentario+1;
    }
     
    public boolean crearEtiqueta(Etiqueta etiq){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "insert into etiqueta(etiqueta, idarticulo) values(?,?)";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, etiq.getEtiqueta());
            prepareStatement.setInt(2, etiq.getIdarticulo());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public boolean modificarEtiqueta(Etiqueta etiq){
        boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "update etiqueta set etiqueta=?, idarticulo=? where idetiqueta=?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, etiq.getEtiqueta());
            prepareStatement.setInt(2, etiq.getIdarticulo());
            prepareStatement.setInt(3, etiq.getIdetiqueta());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public boolean borrarEtiqueta(int idArticulo, int idEtiqueta){
        boolean ok =false;
        String query;
        PreparedStatement prepareStatement;        
        Connection con = null;      
        
        try {
           //Si el idEtiqueta es mayor que cero, borramos solo la etiqueta indicada,
           // de lo contrario se borran todas las etiquetas de este articulo
            if (idEtiqueta > 0){
                query = "delete from etiqueta where idetiqueta=?";
                con = getConexion();
                prepareStatement = con.prepareStatement(query);
                prepareStatement.setInt(1, idEtiqueta);
            }else{
                query = "delete from etiqueta where idarticulo=?";
                con = getConexion();
                prepareStatement = con.prepareStatement(query);
                prepareStatement.setInt(1, idArticulo);
            }
                      
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
    
    public List<Etiqueta> listaEtiquetas(int idArticulo) {
        List<Etiqueta> lista = new ArrayList<>();
        Connection con = null;        
        try {
            String query = "select * from etiqueta where idarticulo =?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1, idArticulo);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Etiqueta etiq = new Etiqueta();
                etiq.setIdetiqueta(rs.getInt("idetiqueta"));
                etiq.setEtiqueta(rs.getString("etiqueta"));
                etiq.setIdarticulo(rs.getInt("idarticulo"));
                lista.add(etiq);
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BlogServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lista;
    }
     
}
