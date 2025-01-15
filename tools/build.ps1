Get-ChildItem -Name  -Filter "*.java" > sources.txt
javac '@sources.txt'