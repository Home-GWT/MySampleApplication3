package com.sample.client.gwt_rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * (клас службы GWT) определение службы на стороне клиента. Этот интерфейс расширяет интерфейс тега RemoteService
 */

@RemoteServiceRelativePath("MyService")
public interface AppService extends RemoteService {

    /* Sample interface method of remote interface */
    String getMessage(String msg);

    /**
     * https://drive.google.com/file/d/0B418nT5Bo9w_engtSTdpVDllY2s/view ( https://github.com/Home-GWT/docs/blob/master/gwt-tutorial-ru.pdf )
     * Создайте прокси сервисного класса:
     */
    public static class App {
        private static AppServiceAsync ourInstance = GWT.create(AppService.class);
        public static synchronized AppServiceAsync getInstance() { return ourInstance; }
    }

}
