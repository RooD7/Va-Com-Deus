@echo off
if exist "./Va-Com-Deus.jar" goto programaEncontrado

echo Nao foi possivel encontrar o programa especificado.
pause
goto fim

:programaEncontrado

java -jar ./Va-Com-Deus.jar

:fim
