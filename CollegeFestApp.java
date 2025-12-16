import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

// Event class with trim() support
class Event {
    String name, venue, date;
    Event(String n, String v, String d) {
        name = n.trim();
        venue = v.trim();
        date = d.trim();
    }
    public String toString() {
        return name + " | " + venue + " | " + date;
    }
}

// Participant class with trim() support
class Participant {
    String name, event, year;
    Participant(String n, String e, String y) {
        name = n.trim();
        event = e.trim();
        year = y.trim();
    }
    public String toString() {
        return name + " | " + year + " | " + event;
    }
}

// Volunteer class with trim() support
class Volunteer {
    String name, dept;
    Volunteer(String n, String d) {
        name = n.trim();
        dept = d.trim();
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
            String eventName = en.getText().trim();
            String venue = ev.getText().trim();
            String date = ed.getText().trim();
            if (eventName.isEmpty() || venue.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (Event event : events) {
                if (event.name.equalsIgnoreCase(eventName)) {
                    JOptionPane.showMessageDialog(this, "Event already exists!", "Duplicate", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            Event event = new Event(eventName, venue, date);
            events.add(event);
            eventModel.addElement(event.toString());
            en.setText(""); ev.setText(""); ed.setText("");
            JOptionPane.showMessageDialog(this, "Event added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
        JList<String> list = new JList<>(eventModel);
        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx == -1) {
                JOptionPane.showMessageDialog(this, "Select an event!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int c = JOptionPane.showConfirmDialog(this, "Delete?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (c == JOptionPane.YES_OPTION) {
                events.remove(idx);
                eventModel.remove(idx);
                JOptionPane.showMessageDialog(this, "Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
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
            String name = pn.getText().trim();
            String year = py.getText().trim();
            String event = pe.getText().trim();
            if (name.isEmpty() || year.isEmpty() || event.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Participant pt = new Participant(name, event, year);
            participants.add(pt);
            partModel.addElement(pt.toString());
            pn.setText(""); py.setText(""); pe.setText("");
            JOptionPane.showMessageDialog(this, "Registered!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
        JList<String> list = new JList<>(partModel);
        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                int c = JOptionPane.showConfirmDialog(this, "Delete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (c == JOptionPane.YES_OPTION) {
                    participants.remove(idx);
                    partModel.remove(idx);
                }
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
            String name = vn.getText().trim();
            String dept = vd.getText().trim();
            if (name.isEmpty() || dept.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Volunteer v = new Volunteer(name, dept);
            volunteers.add(v);
            volModel.addElement(v.toString());
            vn.setText(""); vd.setText("");
            JOptionPane.showMessageDialog(this, "Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
        JList<String> list = new JList<>(volModel);
        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx != -1) {
                int c = JOptionPane.showConfirmDialog(this, "Delete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (c == JOptionPane.YES_OPTION) {
                    volunteers.remove(idx);
                    volModel.remove(idx);
                }
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
        SwingUtilities.invokeLater(() -> new CollegeFestApp());
    }
}
