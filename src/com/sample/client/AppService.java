package com.sample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MyService")
public interface AppService extends RemoteService {

    /* Sample interface method of remote interface */
    String getMessage(String msg);

    /* Use MySampleApplication2Service.App.getInstance() to access static instance of MySampleApplication2ServiceAsync */
    public static class App {
        private static AppServiceAsync ourInstance = GWT.create(AppService.class);
        public static synchronized AppServiceAsync getInstance() { return ourInstance; }
    }

}
