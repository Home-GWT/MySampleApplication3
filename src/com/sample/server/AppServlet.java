package com.sample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sample.client.AppService;

public class AppServlet extends RemoteServiceServlet implements AppService {

    /* Implementation of sample interface method */
    @Override
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"";
    }

}