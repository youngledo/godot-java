@echo off
REM Build script for godot-java on Windows
REM Usage: build-windows.bat

setlocal enabledelayedexpansion

REM Check JAVA_HOME
if "%JAVA_HOME%"=="" (
    echo ERROR: JAVA_HOME not set. Please set it to your JDK installation.
    exit /b 1
)

REM Output directory
set "OUTPUT_DIR=%~dp0build"
if not exist "%OUTPUT_DIR%" mkdir "%OUTPUT_DIR%"

REM Output library name (Windows uses .dll)
set "OUTPUT_LIB=%OUTPUT_DIR%\libgodot-java.dll"
set "SOURCE_FILE=%~dp0src\godot_java.cpp"

echo Building godot-java for Windows...
echo JAVA_HOME: %JAVA_HOME%
echo Output: %OUTPUT_LIB%
echo Source: %SOURCE_FILE%

REM Try MSVC first (available via ilammy/msvc-dev-cmd in CI)
where cl.exe >nul 2>&1
if %errorlevel%==0 (
    echo Using MSVC compiler...
    cl.exe /LD /EHsc /O2 /I "%JAVA_HOME%\include" /I "%JAVA_HOME%\include\win32" /Fo"%OUTPUT_DIR%\godot_java.obj" "%SOURCE_FILE%" /link /OUT:"%OUTPUT_LIB%"
    if not exist "%OUTPUT_LIB%" (
        echo ERROR: MSVC compilation failed - DLL not produced
        exit /b 1
    )
    echo MSVC build successful
    goto :copy_and_exit
)

REM Try MinGW
where g++ >nul 2>&1
if %errorlevel%==0 (
    echo Using MinGW g++ compiler...
    g++ -shared -o "%OUTPUT_LIB%" -I "%JAVA_HOME%\include" -I "%JAVA_HOME%\include\win32" -std=c++17 -fvisibility=hidden -static-libgcc -static-libstdc++ "%SOURCE_FILE%"
    if not exist "%OUTPUT_LIB%" (
        echo ERROR: MinGW compilation failed - DLL not produced
        exit /b 1
    )
    echo MinGW build successful
    goto :copy_and_exit
)

echo ERROR: No C++ compiler found. Please install MSVC or MinGW.
exit /b 1

:copy_and_exit
REM Clean up MSVC intermediate files
if exist "%OUTPUT_DIR%\godot-java.lib" del "%OUTPUT_DIR%\godot-java.lib"
if exist "%OUTPUT_DIR%\godot-java.exp" del "%OUTPUT_DIR%\godot-java.exp"
if exist "%OUTPUT_DIR%\godot_java.obj" del "%OUTPUT_DIR%\godot_java.obj"

echo Build successful: %OUTPUT_LIB%

REM Deploy to shared-native (examples use symlinks)
set "SHARED_NATIVE=%~dp0..\..\godot-java-examples\examples\shared-native"
if not exist "%SHARED_NATIVE%" mkdir "%SHARED_NATIVE%"
copy /Y "%OUTPUT_LIB%" "%SHARED_NATIVE%\" >nul
echo Deployed to shared-native\

exit /b 0
