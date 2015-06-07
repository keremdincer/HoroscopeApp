import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoroscopeButton extends JButton {

    Horoscope horoscope;
    UI ui;

    public HoroscopeButton(final Horoscope horoscope, final UI ui) {

        super();
        this.horoscope = horoscope;
        this.ui = ui;

        setText(horoscope.getName());
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ui.addTab(horoscope);
            }
        });
    }


}
