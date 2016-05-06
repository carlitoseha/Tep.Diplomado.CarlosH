<!DOCTYPE html>
<html>
<head>
   <link type="text/css" rel="stylesheet" href="/css/miEstilo.css"/>
   <title>${titulo}</title>
</head>
<body>
    <h1>Ejemplo de formulario</h1>
    <form action="/formulario" method="post" >
        <tr> <td>Matricula:</td>   <td><input name="matricula" type="number"/> </td> </tr> <br/>
        <tr> <td>Nombre:   </td>   <td><input name="nombre" type="text"/>      </td> </tr> <br/>
        <tr> <td>Apellido: </td>   <td><input name="apellido" type="text"/>    </td> </tr> <br/>
        <tr> <td>Telefono: </td>   <td><input name="telefono" type="text"/>    </td> </tr> <br/>
        <button name="enviar" type="submit" class="boton" >Procesar</button>  
    </form>
    <form action="/formularioProcesado" method="post" id="formul">
        <button name="enviar" type="submit" class="boton">Mostrar</button>
    </form>
    <h1>${accion}</h1>
    
</body>
</html>