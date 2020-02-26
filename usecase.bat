@echo off
set ROOT=%CD%
set classes=%ROOT%\algs4\build\classes\java
cd %classes%\main
set CLASSPATH=.;%classes%\main;%classes%\test%ROOT%\algs4\lib\algs4.jar;%CLASSPATH%
