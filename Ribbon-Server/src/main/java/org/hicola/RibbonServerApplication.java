package org.hicola;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * Ribbon服务端
 */
@SpringBootApplication
public class RibbonServerApplication {
    public static void main(String[] args) {
        /*SpringApplication.run(RibbonServerApplication.class, args);*/

        /**
         * 通过控制台输入的方式启动
         */
        Scanner scan = new Scanner(System.in);
        String port = scan.nextLine();
        new SpringApplicationBuilder(RibbonServerApplication.class).properties("server.port=" + port).run(args);

    }
}
