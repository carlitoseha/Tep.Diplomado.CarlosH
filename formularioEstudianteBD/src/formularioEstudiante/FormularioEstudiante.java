package formularioEstudiante;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import freemarker.template.Configuration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import static spark.Spark.*;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author chernandez
 */
public class FormularioEstudiante {

    public static void main(String[] args) {

        staticFileLocation("/publico");

        List<Estudiante> coleccion = new ArrayList<>();

        Map<String, Object> datosEstudiantes = new HashMap<>();

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(FormularioEstudiante.class, "/publico/html");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        //http://localhost:4567/formulario
        get("/formulario", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            atributos.put("guardado", "");
            atributos.put("accion", "");

            return new ModelAndView(atributos, "formulario.ftl");
        }, freeMarkerEngine);

        post("/formulario", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) throws Exception {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                boolean existe = false;
                
                EstudianteServices estudianteServices = new EstudianteServices();
                Estudiante estudiante1 = new Estudiante();
                Estudiante insertar = new Estudiante();
                
                insertar.setMatricula(matricula);
                insertar.setNombre(nombre);
                insertar.setApellido(apellido);
                insertar.setTelefono(telefono);
                insertar.setCarrera("ISC");
                
                if (estudianteServices.getEstudiante(insertar.getMatricula()) == null) {
                    estudianteServices.crearEstudiante(insertar);
                    datosEstudiantes.put("accion", "Estudiante Guardado.");
                }

                datosEstudiantes.put("titulo", "Estudiantes Procesados");
                datosEstudiantes.put("estudiante", coleccion);

                return new ModelAndView(datosEstudiantes, "formulario.ftl");
            }
        }, freeMarkerEngine);

        get("/formularioProcesado", (Request request, Response response) -> {
           String matricula = request.queryParams("matricula");
           EstudianteServices estudianteServices = new EstudianteServices();
           List<Estudiante> listaEstud = new ArrayList<>();
           
           estudianteServices.borrarEstudiante(Integer.parseInt(matricula));
          
           listaEstud = estudianteServices.listaEstudiantes();
           datosEstudiantes.put("titulo", "Estudiantes Procesados");
           datosEstudiantes.put("estudiante", listaEstud);

            return new ModelAndView(datosEstudiantes, "formularioProcesado.ftl");
        }, freeMarkerEngine);

               
        post("/formularioProcesado", (request, response) -> {
            List<Estudiante> listaEstud = new ArrayList<>();
            EstudianteServices estudianteServices = new EstudianteServices();
             
            listaEstud = estudianteServices.listaEstudiantes();
             
            datosEstudiantes.put("titulo", "Estudiantes Procesados");
            datosEstudiantes.put("estudiante", listaEstud);
            
            return new ModelAndView(datosEstudiantes, "formularioProcesado.ftl");
        }, freeMarkerEngine);

        
        
        get("/modificarFormulario", (Request request, Response response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String matricula = request.queryParams("matricula");
            
            EstudianteServices estudianteServices = new EstudianteServices();
            Estudiante estudiante1 = new Estudiante();
            
            estudiante1 = estudianteServices.getEstudiante(matricula);
            
            atributos.put("titulo", "Estudiantes");
            atributos.put("guardado", "");
            atributos.put("matricula", estudiante1.getMatricula());
            atributos.put("nombre", estudiante1.getNombre());
            atributos.put("apellido", estudiante1.getApellido());
            atributos.put("telefono", estudiante1.getTelefono());
                        
            return new ModelAndView(atributos, "modificarFormulario.ftl");
           
        }, freeMarkerEngine);

        post("/modificarFormulario", (Request request, Response response) -> {
            String matricula = request.queryParams("matricula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");

            EstudianteServices estudianteServices = new EstudianteServices();
            Estudiante estudiante1 = new Estudiante();
            
            estudiante1.setMatricula(matricula);
            estudiante1.setNombre(nombre);
            estudiante1.setApellido(apellido);
            estudiante1.setTelefono(telefono);
            
            estudianteServices.actualizarEstudiante(estudiante1);
            
            List<Estudiante> listaEstud = new ArrayList<>();
            listaEstud = estudianteServices.listaEstudiantes();
             
            datosEstudiantes.put("titulo", "Estudiantes Procesados");
            datosEstudiantes.put("estudiante", listaEstud);
            return new ModelAndView(datosEstudiantes, "formularioProcesado.ftl");
        }, freeMarkerEngine);

    }

}
