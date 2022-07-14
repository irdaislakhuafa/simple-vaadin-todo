package com.irdaislakhuafa.simplevaadintodo.view;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/")
@CssImport(value = "./style.css")
public class MainView extends VerticalLayout {
    public MainView() {
        var helloWorld = new H1("Hello World");
        helloWorld.addClassName("center");
        add(helloWorld);
    }
}
