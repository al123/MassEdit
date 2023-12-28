package faa.mass.edit.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

import faa.mass.edit.application.Greeter;

@Route("view")
@UIScope
public class MassEditViewComponent extends Label {

    public MassEditViewComponent(@Autowired Greeter greeter) {
        // it's the same Greeter instance as in the RootComponent class
        setText(greeter.sayHello());
    }
}
