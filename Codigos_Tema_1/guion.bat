@echo off
REM Script para ejecutar un programa 100 veces
REM Para multiples pruebas de ejecucion de codigos Java, a efectos de comprobar varias veces el resultado y comparar

REM En la siguiente linea, ajustar el nombre del fichero a ejecutar; este script debe estar en la misma carpeta
REM El parametro numerico que lee el programa por linea de comandos, debe ajustarse al espacio de busqueda deseado

set program=java primosParalelos 40000000
set count=0

REM En siguiente linea, ajustar el numero de veces que desea que el script repita la ejecucion

set max=100 

:loop
if %count% geq %max% goto end

REM Ejecuta el programa
%program%

set /a count+=1

REM Mostrar progreso (opcional, descomenta para visualizar)
REM echo Iteración: %count%

goto loop

:end
echo Ejecución completada.
