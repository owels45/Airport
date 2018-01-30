// please do not modify

import logging.LogEngine;

public class Application {
    public static void main(String... args) {
        LogEngine.instance.init();

        LogEngine.instance.close();
    }
}