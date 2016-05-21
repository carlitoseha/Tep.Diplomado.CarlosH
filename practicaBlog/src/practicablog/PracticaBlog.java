/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicablog;

import freemarker.template.Configuration;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Session;
import static spark.Spark.get;
import static spark.Spark.halt;

/**
 *
 * @author chernandez
 */
public class PracticaBlog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        staticFileLocation("/recursos");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(PracticaBlog.class, "/recursos/html");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        //http://localhost:4567/blog
        get("/blog", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            List<Articulo> listaArticulos = new ArrayList<>();
            BlogServices blogServices = new BlogServices();
            listaArticulos = blogServices.listaArticulos();

            Session session = request.session(true);

            if ((session.attribute("username") == null) || (session.attribute("username").toString().trim() == "")){
                session.attribute("username", "");
                session.attribute("administrador", "F");
                session.attribute("autor", "F");
            }
            
            System.out.println(session.attribute("administrador").toString());
            System.out.println(session.attribute("autor").toString());
            
            atributos.put("username", session.attribute("username"));
            atributos.put("administrador", session.attribute("administrador").toString());
            atributos.put("autor", session.attribute("autor").toString());
            atributos.put("articulo", listaArticulos);

            return new ModelAndView(atributos, "blog.html");
        }, freeMarkerEngine);

        //http://localhost:4567/login
        get("/login", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            //atributos.put("titulo", "Estudiantes");
            //atributos.put("guardado", "");
            //atributos.put("accion", "");

            return new ModelAndView(atributos, "login.html");
        }, freeMarkerEngine);

        //http://localhost:4567/login
        post("/login", (Request request, Response response) -> {
            Map<String, Object> atributos = new HashMap<>();
            Usuario usuario = new Usuario();
            Session session = request.session(true);
            BlogServices blogServices = new BlogServices();

            usuario = blogServices.validarUsuario(request.queryParams("username"), request.queryParams("password"));

            if (usuario == null) {
                halt(401, "Credenciales no validas.");
                session.attribute("username", "");
                session.attribute("nombre", "");
                session.attribute("password", "");
                session.attribute("administrador", "F");
                session.attribute("autor", "F");
            } else {
                session.attribute("username", usuario.getUsername());
                session.attribute("nombre", usuario.getNombre());
                session.attribute("password", usuario.getPassword());
                session.attribute("administrador", usuario.getAdministrador());
                session.attribute("autor", usuario.getAutor());
            }

//            atributos.put("username", session.attribute("username"));
//            atributos.put("administrador", session.attribute("administrador"));
//            atributos.put("autor", session.attribute("autor"));
            
//            List<Articulo> listaArticulos = new ArrayList<>();
//            listaArticulos = blogServices.listaArticulos();
//            atributos.put("articulo", listaArticulos);
            
            response.redirect("/blog");
            return new ModelAndView(atributos, "blog.html");
        }, freeMarkerEngine);

        //http://localhost:4567/blogPost
        get("/blogPost", (Request request, Response response) -> {
            int idarticulo = Integer.parseInt(request.queryParams("idarticulo"));
            Map<String, Object> atributos = new HashMap<>();

            Articulo art = new Articulo();
            List<Comentario> coment = new ArrayList<>();
            List<Etiqueta> etiq = new ArrayList<>();

            BlogServices blogServices = new BlogServices();

            //Traer el articulo
            art = blogServices.getArticulo(idarticulo);
            //Traer los comentarios
            coment = blogServices.listaComentarios(idarticulo);
            //Traer las etiquetas
            etiq = blogServices.listaEtiquetas(idarticulo);

            
            Session session = request.session(true);
             if (session.attribute("username") == null) {
                session.attribute("username", "");
                session.attribute("administrador", "F");
                session.attribute("autor", "F");
            }

            atributos.put("username", session.attribute("username"));
            atributos.put("administrador", session.attribute("administrador"));
            atributos.put("autor", session.attribute("autor"));
            
            atributos.put("articulo", art);
            atributos.put("comentario", coment);
            atributos.put("etiqueta", etiq);

            return new ModelAndView(atributos, "blogPost.html");
        }, freeMarkerEngine);

        get("/crearComentario", (Request request, Response response) -> {
            Map<String, Object> atributos = new HashMap<>();
            int idarticulo = Integer.parseInt(request.queryParams("idarticulo"));
            String comentario = request.queryParams("comentario");
            Comentario coment = new Comentario();
            BlogServices blogServices = new BlogServices();

            int numComentario = blogServices.proxComentario();

            Session session = request.session(true);
            if ((session.attribute("username") != null) && session.attribute("username").toString().trim() != "") {
                if ((comentario != null) && (comentario.toString().isEmpty() == false)) {
                    coment.setIdcomentario(numComentario);
                    coment.setComentario(comentario);
                    coment.setIdarticulo(idarticulo);
                    coment.setUsername(session.attribute("username"));
                    blogServices.crearComentario(coment);
                }
            }

            response.redirect("/blogPost?idarticulo=" + idarticulo);
            return new ModelAndView(atributos, "blogPost.html");
        }, freeMarkerEngine);

        //http://localhost:4567/registro
        get("/registro", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            //atributos.put("titulo", "Estudiantes");
            //atributos.put("guardado", "");
            //atributos.put("accion", "");
            
            return new ModelAndView(atributos, "registro.html");
        }, freeMarkerEngine);

        //http://localhost:4567/registro
        post("/registro", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();

            Usuario usr = new Usuario();

            usr.setUsername(request.queryParams("username"));
            usr.setNombre(request.queryParams("nombre"));
            usr.setPassword(request.queryParams("password"));
            usr.setAdministrador(request.queryParams("administrador"));
            usr.setAutor(request.queryParams("autor"));
            
           // System.err.println(usr.getAdministrador() +"   " + usr.getAutor());
            if (!"T".equals(usr.getAdministrador())){
                usr.setAdministrador("F");
            }
            if (!"T".equals(usr.getAutor())){
                usr.setAutor("F");
            }
            
            BlogServices usuarios = new BlogServices();
            usuarios.crearUsuario(usr);            
            
            response.redirect("/blog");
            return new ModelAndView(atributos, "registro.html");
        }, freeMarkerEngine);

        post("/blogPost", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            Comentario comentario = new Comentario();

            Session session = request.session(true);
            BlogServices blogServices = new BlogServices();

            if ((session.attribute("username") != null) && (session.attribute("username").toString().trim() != "")) {
                comentario.setIdcomentario(blogServices.proxComentario());
                comentario.setComentario(request.queryParams("comentario"));
                comentario.setIdarticulo(Integer.parseInt(request.queryParams("idarticulo")));
                comentario.setUsername(session.attribute("username"));
                blogServices.crearComentario(comentario);
            }

            return new ModelAndView(atributos, "blogPost.html");
        }, freeMarkerEngine);

        //http://localhost:4567/crearArticulo
        get("/crearArticulo", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
                      

            return new ModelAndView(atributos, "crearArticulo.html");
        }, freeMarkerEngine);
        
        //http://localhost:4567/crearArticulo
        post("/crearArticulo", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String titulo = request.queryParams("titulo");
            String cuerpo   = request.queryParams("cuerpo");
            String foto   = request.queryParams("foto");
             BlogServices blogServices = new BlogServices();
            Articulo articulo =  new Articulo();
            Session session = request.session(true);
           
            int idarticulo = blogServices.proxArticulo();
             
            if ((session.attribute("username") != null) && session.attribute("username").toString().trim() != "") {
                  
                 articulo.setIdarticulo(idarticulo);
                 articulo.setUsername(session.attribute("username"));
                 articulo.setAdministrador(session.attribute("administrador"));
                 articulo.setTitulo(titulo);
                 articulo.setCuerpo(cuerpo);
                 articulo.setFoto(foto);
                 blogServices.crearArticulo(articulo);
                 
            }else{
                session.attribute("username", "");
                session.attribute("administrador", "F");
                session.attribute("autor", "F");
                halt(401, "Credenciales no validas.");
             }

            response.redirect("/blog");
            return new ModelAndView(atributos, "blog.html");
        }, freeMarkerEngine);
         //http://localhost:4567/
        get("/salir", (request, response) -> {
           Map<String, Object> atributos = new HashMap<>();
           Session session = request.session(false);
           session.attribute("username", "");
           session.attribute("administrador", "F");
           session.attribute("autor", "F");
           
           response.redirect("/blog");
           return new ModelAndView(atributos, "blog.html");
        }, freeMarkerEngine);
        
        //http://localhost:4567/
        get("/eliminarArticulo", (request, response) -> {
           Map<String, Object> atributos = new HashMap<>();
           Session session = request.session(false);
           BlogServices blogServices = new BlogServices();
           List<Articulo> listaArticulos = new ArrayList<>();
                   
           if ((session.attribute("username") != null) && session.attribute("username").toString().trim() != "") {
               if ("T".equals(session.attribute("administrador").toString())) {
                 listaArticulos = blogServices.listaArticulos();
               }else if("T".equals(session.attribute("autor").toString())) {
                 listaArticulos =  blogServices.listaArticulosAutor(session.attribute("username").toString());
               }
            }
          
           atributos.put("articulo", listaArticulos);
           return new ModelAndView(atributos, "eliminarArticulo.html");
          
        }, freeMarkerEngine);
        get("/eliminarArticulos", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            int idarticulo = Integer.parseInt(request.queryParams("idarticulo"));
             BlogServices blogServices = new BlogServices();
             
            blogServices.borrarArticulo(idarticulo);
            
            response.redirect("/blog");
            return new ModelAndView(atributos, "blog.html");
        }, freeMarkerEngine);
        
        get("/modificarArticulo", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            int idarticulo = Integer.parseInt(request.queryParams("idarticulo"));
            BlogServices blogServices = new BlogServices();
            Articulo art = new Articulo();
            art = blogServices.getArticulo(idarticulo);
            
            atributos.put("articulo", art);
            
            return new ModelAndView(atributos, "/modificarArticulo.html");
        }, freeMarkerEngine);
        
        post("/modificarArticulo", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            int idarticulo = Integer.parseInt(request.queryParams("idarticulo"));
            String titulo = request.queryParams("titulo");
            String cuerpo = request.queryParams("cuerpo");
            String foto = request.queryParams("foto");
            
            BlogServices blogServices = new BlogServices();
            Articulo art = new Articulo();
           
            art.setIdarticulo(idarticulo);
            art.setTitulo(titulo);
            art.setCuerpo(cuerpo);
            art.setFoto(foto);
            
            blogServices.modificarArticulo(art);
            
            response.redirect("/blog");
            return new ModelAndView(atributos, "/blog.html");
        }, freeMarkerEngine);
    }
 }

