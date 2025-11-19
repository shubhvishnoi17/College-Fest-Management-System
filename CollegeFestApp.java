import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Event {
    String name, venue, date;
    Event(String n, String v, String d) { name = n; venue = v; date = d; }
    public String toString() { return name + " | " + venue + " | " + date; }
}

class Participant {
    String name, event, year;
    Participant(String n, String e, String y) { name = n; event = e; year = y; }
    public String toString() { return name + " | " + year + " | " + event; }
}

class Volunteer {
    String name, dept;
    Volunteer(String n, String d) { name = n; dept = d; }
    public String toString() { return name + " | " + dept; }
}

public class CollegeFestApp extends JFrame {

    ArrayList<Event> events = new ArrayList<>();
    ArrayList<Participant> participants = new ArrayList<>();
    ArrayList<Volunteer> volunteers = new ArrayList<>();

    DefaultListModel<String> eventModel = new DefaultListModel<>();
    DefaultListModel<String> partModel = new DefaultListModel<>();
    DefaultListModel<String> volModel = new DefaultListModel<>();

    Color headerColor = new Color(30, 136, 229);
    Color bgColor = new Color(240, 248, 255);
    Font titleFont = new Font("Arial", Font.BOLD, 22);
    Font labelFont = new Font("Arial", Font.PLAIN, 16);

    public CollegeFestApp() {

        setTitle("College Fest Management System");
        setSize(780, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Arial", Font.BOLD, 16));

        tabs.add("🏠 Dashboard", dashboardPanel());
        tabs.add("📅 Events", eventPanel());
        tabs.add("🧑‍🎓 Participants", participantPanel());
        tabs.add("🤝 Volunteers", volunteerPanel());

        add(tabs);
        setVisible(true);
    }

    JPanel dashboardPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JLabel title = new JLabel("COLLEGE FEST MANAGEMENT SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(headerColor);
        title.setBorder(new EmptyBorder(40, 10, 10, 10));

        JLabel info = new JLabel("<html><center>"
                + "Manage Events<br>"
                + "Register Participants<br>"
                + "Add Volunteers<br>"
                + "Schedule & Organize Your College Fest Efficiently"
                + "</center></html>", SwingConstants.CENTER);
        info.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel madeBy = new JLabel("<html><center>"
                + "<br><br><b>Made By:</b><br>"
                + "Shubh Vishnoi (Team Leader)<br>"
                + "Sudhanshu Raj<br>"
                + "Prakash Kumar"
                + "</center></html>", SwingConstants.CENTER);

        madeBy.setFont(new Font("Arial", Font.BOLD, 17));
        madeBy.setForeground(new Color(0, 60, 120));

        p.add(title, BorderLayout.NORTH);
        p.add(info, BorderLayout.CENTER);
        p.add(madeBy, BorderLayout.SOUTH);

        return p;
    }

    JPanel eventPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(new EmptyBorder(20, 20, 20, 20));
        form.setBackground(bgColor);

        JTextField en = new JTextField();
        JTextField ev = new JTextField();
        JTextField ed = new JTextField();

        JButton add = new JButton("Add Event");
        add.setBackground(headerColor);
        add.setForeground(Color.white);
        add.setFont(labelFont);

        form.add(new JLabel("Event Name:")); form.add(en);
        form.add(new JLabel("Venue:")); form.add(ev);
        form.add(new JLabel("Date (DD/MM/YY):")); form.add(ed);
        form.add(add);

        JList<String> list = new JList<>(eventModel);
        list.setFont(labelFont);

        JButton delete = new JButton("Delete Selected");
        delete.setBackground(new Color(244, 67, 54));
        delete.setForeground(Color.white);
        delete.setFont(labelFont);

        JPanel bottom = new JPanel();
        bottom.setBackground(bgColor);
        bottom.add(delete);

        add.addActionListener(a -> {
            if (!en.getText().isEmpty() && !ev.getText().isEmpty() && !ed.getText().isEmpty()) {
                events.add(new Event(en.getText(), ev.getText(), ed.getText()));
                eventModel.addElement(en.getText() + " | " + ev.getText() + " | " + ed.getText());
                en.setText(""); ev.setText(""); ed.setText("");
            }
        });

        delete.addActionListener(a -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                events.remove(idx);
                eventModel.remove(idx);
            }
        });

        p.add(form, BorderLayout.NORTH);
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        p.add(bottom, BorderLayout.SOUTH);

        return p;
    }

    JPanel participantPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(new EmptyBorder(20, 20, 20, 20));
        form.setBackground(bgColor);

        JTextField pn = new JTextField();
        JTextField pe = new JTextField();
        JTextField py = new JTextField();

        JButton add = new JButton("Register Participant");
        add.setBackground(headerColor);
        add.setForeground(Color.white);

        form.add(new JLabel("Participant Name:")); form.add(pn);
        form.add(new JLabel("Event Name:")); form.add(pe);
        form.add(new JLabel("Year:")); form.add(py);
        form.add(add);

        JList<String> list = new JList<>(partModel);
        list.setFont(labelFont);

        JButton delete = new JButton("Delete Selected");
        delete.setBackground(new Color(244, 67, 54));
        delete.setForeground(Color.white);

        JPanel bottom = new JPanel();
        bottom.setBackground(bgColor);
        bottom.add(delete);

        add.addActionListener(a -> {
            if (!pn.getText().isEmpty() && !pe.getText().isEmpty() && !py.getText().isEmpty()) {
                participants.add(new Participant(pn.getText(), pe.getText(), py.getText()));
                partModel.addElement(pn.getText() + " | " + py.getText() + " | " + pe.getText());
                pn.setText(""); pe.setText(""); py.setText("");
            }
        });

        delete.addActionListener(a -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                participants.remove(idx);
                partModel.remove(idx);
            }
        });

        p.add(form, BorderLayout.NORTH);
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        p.add(bottom, BorderLayout.SOUTH);

        return p;
    }

    JPanel volunteerPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBorder(new EmptyBorder(20, 20, 20, 20));
        form.setBackground(bgColor);

        JTextField vn = new JTextField();
        JTextField vd = new JTextField();

        JButton add = new JButton("Add Volunteer");
        add.setBackground(headerColor);
        add.setForeground(Color.white);

        form.add(new JLabel("Volunteer Name:")); form.add(vn);
        form.add(new JLabel("Department:")); form.add(vd);
        form.add(add);

        JList<String> list = new JList<>(volModel);
        list.setFont(labelFont);

        JButton delete = new JButton("Delete Selected");
        delete.setBackground(new Color(244, 67, 54));
        delete.setForeground(Color.white);

        JPanel bottom = new JPanel();
        bottom.setBackground(bgColor);
        bottom.add(delete);

        add.addActionListener(a -> {
            if (!vn.getText().isEmpty() && !vd.getText().isEmpty()) {
                volunteers.add(new Volunteer(vn.getText(), vd.getText()));
                volModel.addElement(vn.getText() + " | " + vd.getText());
                vn.setText(""); vd.setText("");
            }
        });

        delete.addActionListener(a -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                volunteers.remove(idx);
                volModel.remove(idx);
            }
        });

        p.add(form, BorderLayout.NORTH);
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        p.add(bottom, BorderLayout.SOUTH);

        return p;
    }

    public static void main(String[] args) {
        new CollegeFestApp();
    }
}
