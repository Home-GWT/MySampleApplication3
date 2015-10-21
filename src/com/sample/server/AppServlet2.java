package com.sample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sample.client.AppService;

public class AppServlet2 extends RemoteServiceServlet implements AppService {
    @Override
    public String getMessage(String msg) {
        return "Client said-2: \"" + msg + "\"";
    }
}
