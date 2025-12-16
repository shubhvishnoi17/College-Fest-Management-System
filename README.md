# College Fest Management System

## Overview
College Fest Management System is a Java-based desktop application developed to
manage college fest activities such as events, participants, and volunteers.
The project provides a simple and interactive GUI using Java Swing and follows
a modular and structured coding approach.

This project was initially submitted in Review 1 and further improved in Review 2
to enhance validation, robustness, code quality, and user interaction.

---

## Features
- Add and manage college fest events
- Register participants for different events
- Add and manage volunteers
- Dashboard view for quick navigation
- Tab-based user interface for better usability
- Confirmation dialogs for delete operations
- Duplicate entry prevention for events

---

## Technologies Used
- Java
- Java Swing (GUI)
- AWT
- Collections Framework (ArrayList)

---

## Project Structure
# College Fest Management System

## Overview
College Fest Management System is a Java-based desktop application developed to
manage college fest activities such as events, participants, and volunteers.
The project provides a simple and interactive GUI using Java Swing and follows
a modular and structured coding approach.

This project was initially submitted in Review 1 and further improved in Review 2
to enhance validation, robustness, code quality, and user interaction.

---

## Features
- Add and manage college fest events
- Register participants for different events
- Add and manage volunteers
- Dashboard view for quick navigation
- Tab-based user interface for better usability
- Confirmation dialogs for delete operations
- Duplicate entry prevention for events

---

## Technologies Used
- Java
- Java Swing (GUI)
- AWT
- Collections Framework (ArrayList)

---

## Project Structure
CollegeFestManagement/
│
├── CollegeFestApp.java
├── Event.java
├── Participant.java
├── Volunteer.java
└── README.md


---

## Code Quality & Validation
- Input validation is implemented for all forms
- Empty input fields are restricted
- Duplicate events are prevented
- Error messages are shown using dialog boxes
- Confirmation dialogs are used before delete actions

---

## Testing
- Application was tested with empty inputs
- Duplicate event entries were tested
- Delete actions were tested with and without selection
- Application handles invalid operations without crashing

---

## Innovation / Extra Effort
- Improved user interaction using dialog-based feedback
- Added confirmation dialogs for safe deletion
- Prevented duplicate event entries
- Enhanced UI readability and usability

---

## Teamwork & Collaboration
This project was developed as a team effort:

- **Shubh Vishnoi (Team Leader):** Core logic, GUI design, integration, validation
- **Sudhanshu Raj:** UI styling and layout support
- **Prakash Kumar:** Testing, documentation, and validation support

---

## How to Run
1. Open the project in any Java-supported IDE (IntelliJ / Eclipse / NetBeans)
2. Compile and run `CollegeFestApp.java`
3. The application will open as a desktop window
4. 
## How to Deploy Servlet Web Application

### Prerequisites
- Apache Tomcat 9.0 or higher
- JDK 8 or higher
- Servlet API JAR

### Deployment Steps

1. **Compile Servlet Files**
   ```bash
   cd src/com/collegefest/servlet
   javac -cp "path/to/servlet-api.jar" *.java
   ```

2. **Create Directory Structure**
   ```
   CollegeFestApp/
   ├── index.html
   ├── events.html
   ├── participants.html
   ├── volunteers.html
   ├── css/
   │   └── style.css
   └── WEB-INF/
       ├── web.xml
       └── classes/
           └── com/
               └── collegefest/
                   └── servlet/
                       ├── EventServlet.class
                       ├── ParticipantServlet.class
                       └── VolunteerServlet.class
   ```

3. **Deploy to Tomcat**
   - Copy entire `webapp` folder to `tomcat/webapps/CollegeFestApp`
   - Ensure compiled `.class` files are in `WEB-INF/classes/com/collegefest/servlet/`

4. **Start Tomcat Server**
   - Windows: Run `tomcat/bin/startup.bat`
   - Linux/Mac: Run `tomcat/bin/startup.sh`

5. **Access Application**
   - Open browser: `http://localhost:8080/CollegeFestApp/`
   - Navigate between Events, Participants, and Volunteers pages

### Testing Servlet Features

1. **Test Event Management**
   - Add new event with all details
   - Try adding duplicate event (should show error)
   - Submit empty form (should show validation error)

2. **Test Participant Registration**
   - Register participant for an event
   - Check success message
   - Test with empty fields

3. **Test Volunteer Addition**
   - Add volunteer with department
   - Verify success feedback
   - Test validation

---

## Conclusion
This project demonstrates the practical use of Java Swing, event handling,
validation techniques, and clean coding practices.
