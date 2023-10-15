# Сборка и запуск приложения
cd 1.1-java-basics/src

### Компиляция:
*javac run/Main/java*

### Запуск:
*java run/Main.java*

### Сборка jar:
*jar cvfm run/Main.jar run/manifest.txt run/*.class*

### Посмотреть содержимое jar:
*jar tf run/Main.jar*

### Запуск:
*java -cp run/Main.jar run.Main*
