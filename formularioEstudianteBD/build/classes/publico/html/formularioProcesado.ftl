<!DOCTYPE html>
<html>
<head>
    <title>${titulo}</title>
</head>
<body>
    <h1>Procesando Formulario</h1>
    <table>
        <tbody>
        <tr><td>Matricula</td> <td>Nombre</td> <td> Apellido </td> <td> Telefono </td> <tr>    
       <#list estudiante as estud> 
        <form action="/formularioProcesado" method="post">
             <tr><td>${estud.matricula}</td> 
                 <td>${estud.nombre}</td> 
                 <td>${estud.apellido}</td> 
                 <td>${estud.telefono}</td> 
                 <td> <a href="/formularioProcesado?matricula=${estud.matricula}">Eliminar</a></td>
                 <td> <a href="/modificarFormulario?matricula=${estud.matricula}">Modificar</a></td>
              </tr>
        </form>   
        </#list>
        </tbody>
    </table>
</body>
</html>
