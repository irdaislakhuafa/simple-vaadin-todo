package com.irdaislakhuafa.simplevaadintodo.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/")
@PageTitle(value = "Simple Vaadin Todo")
@CssImport(value = "./style.css")
public class MainView extends VerticalLayout {
    private final int notifDuration = (1000 * 2);
    private final Position notifPosition = Position.BOTTOM_CENTER;

    public MainView() {
        final var labelApp = new H1("Simple Vaadin Todo");
        labelApp.addClassName("center");
        add(labelApp);

        // to store todo list
        final var todoList = new VerticalLayout();

        // input text
        var inputText = new TextField("Input Text Here!");
        inputText.setPlaceholder("Here!");
        inputText.setAutocapitalize(Autocapitalize.WORDS);

        // add button for todo list
        final var addButton = new Button(new Icon(VaadinIcon.PLUS));
        addButton.addClickListener((button) -> {
            final var text = inputText.getValue();
            if (text.isBlank() || text.isBlank()) {
                Notification.show("Please insert text first!", notifDuration, notifPosition);
                return;
            }

            if (inputText.getValue().contains("babi")) {
                Notification.show(
                        String.format("Word \"%s\" not allowed", inputText.getValue()),
                        notifDuration,
                        notifPosition);
                return;
            }

            final var checkBox = new Checkbox(text);
            todoList.add(checkBox);
            inputText.setValue("");
        });

        final var inputTodoList = new HorizontalLayout(inputText, addButton);
        inputTodoList.addClassName("center");
        inputTodoList.setAlignItems(Alignment.END);
        add(inputTodoList);

        add(new HorizontalLayout(todoList) {
            {
                addClassName("checkbox-view");
            }
        });
    }
}
