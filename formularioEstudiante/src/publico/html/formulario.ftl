<!DOCTYPE html>
<html>
<head>
   <title>${titulo}</title>
    
</head>
<body>
    <h1>Ejemplo de formulario</h1>
    <form action="/formulario" method="post">
         Matricula: <input name="matricula" type="number"/><br/>
         Nombre: <input name="nombre" type="text"/><br/>
         Apellido: <input name="apellido" type="text"/><br/>  
         Telefono: <input name="telefono" type="text"/><br/>
        <button name="enviar" type="submit">Procesar</button>  <h1>${accion}</h1>
        
    </form>
    <form action="/formularioProcesado" method="post">
        <button name="enviar" type="submit">Mostrar</button>
    </form>
    
    
</body>
</html>