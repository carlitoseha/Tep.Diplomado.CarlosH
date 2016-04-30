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

        // http://localhost:4567/formulario
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
                int matricula = Integer.parseInt(request.queryParams("matricula"));
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                boolean existe = false;

                Estudiante estudiante1 = new Estudiante(matricula, nombre, apellido, telefono);

                datosEstudiantes.put("titulo", "Estudiantes Procesados");
                datosEstudiantes.put("estudiante", coleccion);

                //Si la colleccion esta en blanco, agregamos el primer valor
                if (coleccion.size() <= 0) {
                    coleccion.add(estudiante1);
                    datosEstudiantes.put("accion", "Estudiante Guardado.");
                } else {
                    //ciclo para controlar que no guarde dos estudiantes repetidos
                    for (int i = 0; i < coleccion.size(); i++) {
                        if (coleccion.get(i).getMatricula() == estudiante1.getMatricula()) {
                            existe = true;
                            break;
                        }
                    }
                    if (existe == true) {
                        datosEstudiantes.put("accion", "Estudiante ya existe.");
                    } else {
                        coleccion.add(estudiante1);
                        datosEstudiantes.put("accion", "Estudiante Guardado.");
                    }

                }
                return new ModelAndView(datosEstudiantes, "formulario.ftl");
            }
        }, freeMarkerEngine);

        get("/formularioProcesado", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            for (int i = 0; i < coleccion.size(); i++) {
                if (coleccion.get(i).getMatricula() == matricula) {
                    coleccion.remove(i);
                }
            }
            
            System.out.println(matricula);
            datosEstudiantes.put("titulo", "Estudiantes Procesados");
            datosEstudiantes.put("estudiante", coleccion);
                
            return new ModelAndView(datosEstudiantes, "formularioProcesado.ftl");
        }, freeMarkerEngine);

        post("/formularioProcesado", (request, response) -> {

            return new ModelAndView(datosEstudiantes, "formularioProcesado.ftl");
        }, freeMarkerEngine);

    }

}
