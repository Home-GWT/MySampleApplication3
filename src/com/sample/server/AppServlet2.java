package com.sample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sample.client.gwt_rpc.AppService;

/**
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * сервлет, реализующий интерфейс ContactsService и предоставляющий возможность получения результатов обоаботки данных с помощью RPC
 */

public class AppServlet2 extends RemoteServiceServlet implements AppService {
    @Override
    public String getMessage(String msg) {
        return "Client said-2: \"" + msg + "\"";
    }
}
