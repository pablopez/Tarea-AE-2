# Tarea-AE-2

La primera versión (calcUI.java) tiene el objetivo de cumplir con la primera parte del ejercicio:
* dos cajas de texto para introducir dos números
* Opciones de sumar, restar, multiplicar, dividir
* opción de raíz cuadrada no permitida
* opción de raíz cúbica bajo contraseña (0000)
La opción de raiz cública tomará el primer número introducido. 

La segunda versión (calcNiceUI.java) tiene el objetivo de cumplir la segunda parte del ejercicio que consiste en mejorar la UEX y mejorar el diseño. 

Se han añadido las siguientes modificaciones relacionadas con el diseño:
* Se ha optado con un diseño plano con colores en escala de grises suaves para mejor contrase con el negro
* Se ha homogeneizado el fondo a blanco para que se vea más claro todo 
* Letras y números en negrita poniéndo más énfasis en las inputs y el resultado final (tamaño de texto un punto más grande)
* Se ha añadido un icono para la aplicación en la parte superior

Relacionado con la UEX se han añadido las siguientes mejoras:
* eventos de teclado: 
  - Se ha añadido el evento de cerrar pulsando la tecla ESC
  - Se ha añadido un evento para llevar el foco al input 1 pulsando z y al 2 pulsando x
  - Se ha añadido eventos para sumar, restar, multiplicar y dividir pulsando los signos de operación de la parte numérica del teclado
  - Se ha añadido un evento para ir a hacer raíz cuadrada pulsando en q
  - Se ha añadido un evento para ir a hacer raíz cúbica pulsando en w
  - Se controla la entrada por teclado para hacer imposible al usuario introducir caracteres incorrectos

