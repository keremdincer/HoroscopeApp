import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoroscopePanel extends JPanel {

    UI ui;
    HoroscopePanel self;
    Horoscope horoscope;
    JLabel titleLbl;
    JButton closeBtn;
    JTextArea textArea;

    public HoroscopePanel(Horoscope horoscope, UI ui) {
        super();
        this.self = this;
        this.ui = ui;
        this.horoscope = horoscope;
        setComponents();
    }

    void setComponents() {

        setLayout(new BorderLayout());

        titleLbl = new JLabel(horoscope.getName(), SwingConstants.CENTER);
        closeBtn = new JButton("Close Tab");
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.removeTab(self);
            }
        });
        textArea = new JTextArea();
        textArea.setText(horoscope.getDaily());
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(UIManager.getColor("Label.background"));
        textArea.setFont(UIManager.getFont("Label.font"));
        textArea.setBorder(UIManager.getBorder("Label.border"));

        this.add(titleLbl, BorderLayout.NORTH);
        this.add(textArea, BorderLayout.CENTER);
        this.add(closeBtn, BorderLayout.SOUTH);
    }

    public Horoscope getHoroscope() {

        return horoscope;
    }
}
