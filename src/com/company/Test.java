package com.company;

import java.io.IOException;

public class Test implements AutoCloseable {
    private String string;

    Test(String string) throws IOException {
        if (string == null) {
            throw new IOException("Объект не может быть создан с параметром null");
        } else {
            this.string = string;
        }
    }

    public void getTest() {
        System.out.println("Test - работа началась");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Test - работа завершена");
    }

    public static void main(String[] args) throws Exception {
        try (Test test = new Test("Hi")) {
            test.getTest();
        }

        Test test1 = new Test(null);
    }
}
//Благодаря выбрасыванию исключения в конструкторе мы можем указать на проблему, что объект был создан как - то не так, как мы хотели. Главное выбрать правильное исключение.


