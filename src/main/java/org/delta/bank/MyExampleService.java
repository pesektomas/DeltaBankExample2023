package org.delta.bank;

public class MyExampleService {

    static MyExampleService instance;

    private MyExampleService() {
    }

    public static MyExampleService getInstance() {
        if (instance == null) {
            instance = new MyExampleService();
        }

        return instance;

    }


}
