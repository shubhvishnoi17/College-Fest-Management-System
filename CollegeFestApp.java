import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

class Event {
    String name, venue, date;
    Event(String n, String v, String d) {
        name = n;
        venue = v;
        date = d;
    }
    public String toString() {
        return name + " | " + venue + " | " + date;
    }
}

class Participant {
    String name, event, year;
    Participant(String n, String e, String y) {
        name = n;
        event = e;
        year = y;
    }
    public String toString() {
        return name + " | " + year + " | " + event;
    }
}

class Volunteer {
    String name, dept;
    Volunteer(String n, String d) {
        name = n;
        dept = d;
    }
    public String toString() {
        return name + " | " + dept;
    }
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
    Font labelFont = new Font("Arial", Font.PLAIN, 16);

    public CollegeFestApp() {

        setTitle("College Fest Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Arial", Font.BOLD, 15));

        tabs.add("Dashboard", dashboardPanel());
        tabs.add("Events", eventPanel());
        tabs.add("Participants", participantPanel());
        tabs.add("Volunteers", volunteerPanel());

        add(tabs);
        setVisible(true);
    }

    JPanel dashboardPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JLabel title = new JLabel("COLLEGE FEST MANAGEMENT SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(headerColor);
        title.setBorder(new EmptyBorder(30, 10, 10, 10));

        JLabel info = new JLabel(
                "<html><center>Manage Events<br>Register Participants<br>Add Volunteers</center></html>",
                SwingConstants.CENTER
        );
        info.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel madeBy = new JLabel(
                "<html><center><br><b>Made By</b><br>Shubh Vishnoi (Team Leader)<br>Sudhanshu Raj<br>Prakash Kumar</center></html>",
                SwingConstants.CENTER
        );

        p.add(title, BorderLayout.NORTH);
        p.add(info, BorderLayout.CENTER);
        p.add(madeBy, BorderLayout.SOUTH);
        return p;
    }

    JPanel eventPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JTextField en = new JTextField();
        JTextField ev = new JTextField();
        JTextField ed = new JTextField();

        JButton add = new JButton("Add Event");
        add.setBackground(headerColor);
        add.setForeground(Color.WHITE);

        add.addActionListener(e -> {
            if (en.getText().isEmpty() || ev.getText().isEmpty() || ed.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required");
                return;
            }
            for (Event event : events) {
                if (event.name.equalsIgnoreCase(en.getText())) {
                    JOptionPane.showMessageDialog(this, "Event already exists");
                    return;
                }
            }
            Event event = new Event(en.getText(), ev.getText(), ed.getText());
            events.add(event);
            eventModel.addElement(event.toString());
            en.setText(""); ev.setText(""); ed.setText("");
        });

        JList<String> list = new JList<>(eventModel);

        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx == -1) return;
            int c = JOptionPane.showConfirmDialog(this, "Delete selected event?");
            if (c == 0) {
                events.remove(idx);
                eventModel.remove(idx);
            }
        });

        JPanel form = new JPanel(new GridLayout(4,2,10,10));
        form.setBorder(new EmptyBorder(20,20,20,20));
        form.setBackground(bgColor);
        form.add(new JLabel("Event Name")); form.add(en);
        form.add(new JLabel("Venue")); form.add(ev);
        form.add(new JLabel("Date")); form.add(ed);
        form.add(add);

        p.add(form, BorderLayout.NORTH);
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        p.add(delete, BorderLayout.SOUTH);
        return p;
    }

    JPanel participantPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JTextField pn = new JTextField();
        JTextField py = new JTextField();
        JTextField pe = new JTextField();

        JButton add = new JButton("Register");
        add.addActionListener(e -> {
            if (pn.getText().isEmpty() || py.getText().isEmpty() || pe.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields required");
                return;
            }
            Participant pt = new Participant(pn.getText(), pe.getText(), py.getText());
            participants.add(pt);
            partModel.addElement(pt.toString());
            pn.setText(""); py.setText(""); pe.setText("");
        });

        JList<String> list = new JList<>(partModel);

        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                participants.remove(idx);
                partModel.remove(idx);
            }
        });

        JPanel form = new JPanel(new GridLayout(4,2,10,10));
        form.setBorder(new EmptyBorder(20,20,20,20));
        form.setBackground(bgColor);
        form.add(new JLabel("Name")); form.add(pn);
        form.add(new JLabel("Year")); form.add(py);
        form.add(new JLabel("Event")); form.add(pe);
        form.add(add);

        p.add(form, BorderLayout.NORTH);
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        p.add(delete, BorderLayout.SOUTH);
        return p;
    }

    JPanel volunteerPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(bgColor);

        JTextField vn = new JTextField();
        JTextField vd = new JTextField();

        JButton add = new JButton("Add");
        add.addActionListener(e -> {
            if (vn.getText().isEmpty() || vd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields required");
                return;
            }
            Volunteer v = new Volunteer(vn.getText(), vd.getText());
            volunteers.add(v);
            volModel.addElement(v.toString());
            vn.setText(""); vd.setText("");
        });

        JList<String> list = new JList<>(volModel);

        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                volunteers.remove(idx);
                volModel.remove(idx);
            }
        });

        JPanel form = new JPanel(new GridLayout(3,2,10,10));
        form.setBorder(new EmptyBorder(20,20,20,20));
        form.setBackground(bgColor);
        form.add(new JLabel("Name")); form.add(vn);
        form.add(new JLabel("Department")); form.add(vd);
        form.add(add);

        p.add(form, BorderLayout.NORTH);
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        p.add(delete, BorderLayout.SOUTH);
        return p;
    }

    public static void main(String[] args) {
        new CollegeFestApp();
    }
}
