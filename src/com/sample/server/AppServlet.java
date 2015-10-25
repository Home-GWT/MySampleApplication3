package com.sample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sample.client.gwt_rpc.AppService;

/**
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * сервлет, реализующий интерфейс ContactsService и предоставляющий возможность получения результатов обоаботки данных с помощью RPC
 */

public class AppServlet extends RemoteServiceServlet implements AppService {

    /* Implementation of sample interface method */
    @Override
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"";
    }

}