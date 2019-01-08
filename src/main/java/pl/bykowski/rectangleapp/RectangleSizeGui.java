package pl.bykowski.rectangleapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;



@Route
public class RectangleSizeGui extends VerticalLayout {

    private RectangleRepo rectangleRepo;

    private TextField textFieldSize;
    private TextArea textAreaRectangle;
    private Button buttonBigger;
    private Button buttonSmaller;


    @Autowired
    public RectangleSizeGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        this.textFieldSize = new TextField("Podaj rozmiar");
        textAreaRectangle = new TextArea("Rezultat:");
        buttonBigger = new Button("pokaż większe");
        buttonSmaller = new Button("pokaż mniejsze");

        buttonBigger.addClickListener(clickEvent -> textAreaRectangle.setValue(rectangleRepo.getBigRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));
        buttonSmaller.addClickListener(clickEvent -> textAreaRectangle.setValue(rectangleRepo.getSmallRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));

        add(textFieldSize);
        add(buttonBigger);
        add(buttonSmaller);
        add(textAreaRectangle);

    }
}
