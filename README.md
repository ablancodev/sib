# sib
Sib - Lenguaje de programación

## Ficheros destacables

sib_ejecutable.jar : Último fichero ejecutable

sib/flex/AnalizadorLexicoFase2.flex : Fichero flex analizador léxico
sib/cup/Sintactico.cup : Fichero cup analizador sintáctico

## Notas sobre la ejecución del .jar
Actualmente el traductor lee y valida el código que se escriba en el editor izquierdo, mostrando el log en el editor derecho de salida.
Hay tres botones en la barra de herramientas:

- Load file: Carga códigos .sib. En la carpeta 'examples' hay varios ejemplos, algunos con sentido y otros sin él.
- Run Sib: Ejecuta el analizador del código sib. Es el botón que hay que usar.
- Run Sid: Ejecuta el analizador del código sid, es decir, del fichero de definiciones. Esto sería para extender del tipos de datos, y poder crear tipos propios. Aún por ver si esta funcionalidad va a estar implementada o no en la versión final, por lo que en principio este botón será borrado. La idea era poder crear tipos propios que extienden de object, y crear por ejemplo "notas de colores", con propiedades propias,como por ejemplo el color. En la carpeta examples hay un fichero de pruebas, pero aun por ver si dará tiempo de añadir esta funcionalidad.