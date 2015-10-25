package com.sample.client.gwt_rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * асинхронный интерфейс, основанный на исходном интерфейсе ContactsService. Он предоставляет объект обратного вызова, обеспечивающий асинхронную связь между сервером и клиентом
 */

public interface AppServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
