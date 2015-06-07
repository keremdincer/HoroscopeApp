import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class UI extends JFrame{

    JPanel splash;

    HoroscopeButton[] horoscopeBtns;
    String[] horoscopeNames = {
            "aries", "taurus", "gemini",
            "cancer", "leo", "virgo",
            "libra", "scorpio", "sagittarius",
            "capricorn", "aquarius", "pisces"
    };
    ArrayList<HoroscopePanel> panels;
    Horoscope[] horoscopes;
    JTabbedPane tabs;

    public UI() {

        setSpecs();
        setComponents();
    }

    void setSpecs() {

        setSize(400, 400);
        setResizable(false);
        setTitle("Horoscopes v0.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void setComponents() {

        horoscopes = new Horoscope[12];
        panels = new ArrayList<HoroscopePanel>();

        tabs = new JTabbedPane();

        splash = new JPanel();
        splash.setLayout(new GridLayout(3,4));
        horoscopeBtns = new HoroscopeButton[12];
        for (int i = 0; i < 12; i++) {

            horoscopes[i] = new Horoscope(horoscopeNames[i]);
            horoscopeBtns[i] = new HoroscopeButton(horoscopes[i], this);
            splash.add(horoscopeBtns[i]);
        }

        tabs.addTab("Main", splash);
        add(tabs);

        setVisible(true);
    }

    public void addTab(Horoscope horoscope) {
        boolean exist = false;
        for (HoroscopePanel panel : panels) {
            System.out.println("Loop");
            if (panel.getHoroscope() == horoscope) {
                exist = true;
                tabs.setSelectedComponent(panel);
                break;
            }
        }

        if (!exist) {
            HoroscopePanel clone = new HoroscopePanel(horoscope, this);
            panels.add(clone);
            tabs.addTab(horoscope.getName(), clone);
            tabs.setSelectedIndex(tabs.getTabCount() - 1);
        }
    }

    public void removeTab(HoroscopePanel panel) {

        try {
            for (HoroscopePanel clonePanel : panels) {
                if (panel.getHoroscope().getName().equals(clonePanel.getHoroscope().getName())) {
                    panels.remove(clonePanel);
                }
            }
        } catch (ConcurrentModificationException e) {

            // NOTHING
        }
        tabs.remove(panel);
    }
}
