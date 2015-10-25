package com.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.sample.client.gwt_rpc.AppService;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 * * * * * * * * * * * * * * * * * * * * * * * *
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * пример пользовательского интерфейса, созданный как тестовый клиент. Он может использоваться для вызова службы GWT
 */
public class App implements EntryPoint {

    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    AppService.App.getInstance().getMessage("Hello!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
