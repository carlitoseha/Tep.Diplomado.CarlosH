<!DOCTYPE html>
<html>
<head>
   <title>${titulo}</title>
    
</head>
<body>
    <h1>Ejemplo de formulario</h1>
    <form action="/modificarFormulario" method="post">
         Matricula: <input name="matricula" type="number" value = "${matricula}"/><br/>
         Nombre: <input name="nombre" type="text" value = "${nombre}"/><br/>
         Apellido: <input name="apellido" type="text" value = "${apellido}"/><br/>  
         Telefono: <input name="telefono" type="text" value = "${telefono}"/><br/>
        <button name="enviar" type="submit">Modificar</button>  
        
    </form>
               
</body>
</html>