call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startpage
echo Cannot start server

:startpage
start http://localhost:8080/crud/v1/task/getTasks
