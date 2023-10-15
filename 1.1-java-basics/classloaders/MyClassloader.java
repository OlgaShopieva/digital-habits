package classloaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassloader extends ClassLoader{


    //Переопределяем метод findClass, которому надо передать путь к файлу с расширением .class
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //С помощью потока считываем файл в массив байт
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get("fileName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //С помощью функции defineClass загружаем класс
        Class <?> clazz = defineClass (name, bytes, 0, bytes.length);
        return clazz;
    }

}
