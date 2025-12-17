# 🎓 College Fest Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Servlet](https://img.shields.io/badge/Servlet-007396?style=for-the-badge&logo=java&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

A comprehensive Java-based platform for managing college fest activities with both desktop and web interfaces.

[Features](#-features) • [Tech Stack](#-tech-stack) • [Installation](#-installation) • [Usage](#-usage) • [Team](#-team)

</div>

---

## 📋 Table of Contents
- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Architecture](#-project-architecture)
- [Installation & Setup](#-installation--setup)
  - [Desktop Application](#desktop-application)
  - [Web Application](#web-application-servlet-deployment)
- [Usage](#-usage)
- [Testing](#-testing)
- [Code Quality](#-code-quality)
- [Team](#-team)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🎯 Overview

**College Fest Management System** is a dual-mode application designed to streamline the organization and management of college fest activities. The system offers:

- **Desktop Application**: Java Swing-based GUI for offline management
- **Web Application**: Servlet-based web interface for online accessibility

The platform enables efficient management of events, participant registrations, and volunteer coordination, making college fest organization hassle-free.

### 🌟 Key Highlights
- ✅ Dual interface (Desktop + Web)
- ✅ Input validation and error handling
- ✅ Duplicate entry prevention
- ✅ User-friendly interface with intuitive navigation
- ✅ Modular and scalable architecture

---

## ✨ Features

### Event Management
- ➕ Add new college fest events with details (name, venue, date)
- 📋 View all registered events
- 🗑️ Delete events with confirmation dialogs
- 🚫 Prevent duplicate event entries

### Participant Management
- 👥 Register participants for specific events
- 📝 Store participant information (name, event, year)
- 📊 View all registered participants
- ✅ Input validation for all fields

### Volunteer Management
- 🙋 Add volunteers with department information
- 📌 Manage volunteer assignments
- 📂 Organized volunteer database

### User Interface
- 🖥️ **Desktop**: Tab-based Swing interface with dashboard
- 🌐 **Web**: Modern HTML/CSS interface with responsive design
- ✔️ Confirmation dialogs for critical operations
- ⚠️ Error messages and success feedback

---

## 🛠️ Tech Stack

### Backend
- **Java SE** - Core application logic
- **Java Swing** - Desktop GUI framework
- **AWT** - Abstract Window Toolkit
- **Java Servlets** - Web application backend
- **Collections Framework** - Data management (ArrayList)

### Frontend (Web)
- **HTML5** - Structure and content
- **CSS3** - Styling and layout
- **Responsive Design** - Mobile-friendly interface

### Server
- **Apache Tomcat 9.0+** - Servlet container

### Build Tools
- **JDK 8+** - Java Development Kit
- **Servlet API** - Web application development

---

## 🏗️ Project Architecture

```
College-Fest-Management-System/
│
├── src/com/collegefest/servlet/         # Servlet classes
│   ├── CollegeFestServlet.java          # Main servlet controller
│   ├── EventServlet.java                # Event management servlet
│   ├── ParticipantServlet.java          # Participant management servlet
│   └── VolunteerServlet.java            # Volunteer management servlet
│
├── webapp/                               # Web application files
│   ├── WEB-INF/
│   │   └── web.xml                      # Deployment descriptor
│   ├── css/
│   │   └── style.css                    # Stylesheet
│   ├── index.html                       # Landing page
│   ├── events.html                      # Event management page
│   ├── participants.html                # Participant registration page
│   └── volunteers.html                  # Volunteer management page
│
├── CollegeFestApp.java                  # Desktop application main class
└── README.md                            # Project documentation
```

### Class Structure
- **Event Class**: Represents event entities with trim validation
- **Participant Class**: Manages participant data with validation
- **Volunteer Class**: Handles volunteer information
- **CollegeFestApp**: Main desktop application with Swing GUI
- **Servlet Classes**: Handle HTTP requests and responses

---

## 📥 Installation & Setup

### Prerequisites
- ☕ JDK 8 or higher
- 🖥️ Java-supported IDE (IntelliJ IDEA / Eclipse / NetBeans)
- 🌐 Apache Tomcat 9.0+ (for web application)
- 📦 Servlet API JAR

### Desktop Application

#### Step 1: Clone the Repository
```bash
git clone https://github.com/shubhvishnoi17/College-Fest-Management-System.git
cd College-Fest-Management-System
```

#### Step 2: Open in IDE
- Open the project in your preferred Java IDE
- Ensure JDK 8+ is configured

#### Step 3: Compile and Run
```bash
# Compile
javac CollegeFestApp.java

# Run
java CollegeFestApp
```

The desktop application window will open with tabs for Events, Participants, and Volunteers.

---

### Web Application (Servlet Deployment)

#### Step 1: Compile Servlet Files
```bash
cd src/com/collegefest/servlet
javac -cp "path/to/servlet-api.jar" *.java
```

#### Step 2: Prepare Directory Structure
Ensure your `webapp` folder follows this structure:
```
webapp/
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
                    ├── CollegeFestServlet.class
                    ├── EventServlet.class
                    ├── ParticipantServlet.class
                    └── VolunteerServlet.class
```

#### Step 3: Deploy to Tomcat
1. Copy the entire `webapp` folder to `TOMCAT_HOME/webapps/CollegeFestApp/`
2. Ensure all `.class` files are in `WEB-INF/classes/com/collegefest/servlet/`

#### Step 4: Start Tomcat Server
**Windows:**
```bash
TOMCAT_HOME\bin\startup.bat
```

**Linux/Mac:**
```bash
TOMCAT_HOME/bin/startup.sh
```

#### Step 5: Access Application
Open your browser and navigate to:
```
http://localhost:8080/CollegeFestApp/
```

---

## 💻 Usage

### Desktop Application
1. **Launch**: Run `CollegeFestApp.java`
2. **Navigate Tabs**: Use tabs to switch between Events, Participants, and Volunteers
3. **Add Entry**: Fill in the form fields and click the respective "Add" button
4. **Delete Entry**: Select an item from the list and click "Delete" (confirmation required)
5. **View Data**: All entries are displayed in scrollable list views

### Web Application
1. **Home Page**: Navigate from `index.html` to different management pages
2. **Event Management**: Go to `events.html` to add/manage events
3. **Participant Registration**: Use `participants.html` to register participants
4. **Volunteer Management**: Access `volunteers.html` for volunteer coordination
5. **Form Submission**: Fill forms and submit via POST requests to servlets

---

## 🧪 Testing

### Desktop Application Tests
- ✅ Empty input validation
- ✅ Duplicate event prevention
- ✅ Delete operation with/without selection
- ✅ Application stability (no crashes on invalid operations)

### Web Application Tests
1. **Event Management**
   - Add new event with all required fields
   - Attempt to add duplicate event (should display error)
   - Submit form with empty fields (should trigger validation)

2. **Participant Registration**
   - Register participant with valid event
   - Verify success message display
   - Test with missing required fields

3. **Volunteer Addition**
   - Add volunteer with department info
   - Verify data persistence
   - Test input validation

### Test Commands
```bash
# Run desktop application
java CollegeFestApp

# Access web application
curl http://localhost:8080/CollegeFestApp/

# Test servlet endpoints
curl -X POST http://localhost:8080/CollegeFestApp/event \
  -d "action=addEvent&eventName=TechFest&venue=MainHall&date=2025-01-15"
```

---

## ✅ Code Quality

### Validation Features
- 🔒 **Input Validation**: All form fields have trim() and empty check validation
- 🚫 **Duplicate Prevention**: Events are checked for duplicates before insertion
- 💬 **User Feedback**: Error and success messages via dialog boxes (desktop) and alerts (web)
- ⚠️ **Confirmation Dialogs**: Critical operations require user confirmation

### Best Practices
- 📦 Modular code structure with separate classes
- 🔄 Reusable components and methods
- 📝 Clear variable and method naming
- 💡 Comprehensive error handling
- 🧹 Clean and maintainable code

---

## 👥 Team

This project was developed as a collaborative team effort:

| Role | Name | Responsibilities |
|------|------|------------------|
| 👨‍💼 **Team Leader** | **Shubh Vishnoi** | Core logic, GUI design, integration, validation, servlet implementation |
| 🎨 **UI Developer** | **Sudhanshu Raj** | UI styling, layout support, responsive design |
| 🧪 **QA Engineer** | **Prakash Kumar** | Testing, documentation, validation support |

---

## 🚀 Innovation & Extra Effort

- 🎨 **Dual Interface**: Developed both desktop and web versions for maximum accessibility
- 🔐 **Enhanced Validation**: Implemented trim() validation to prevent whitespace-only entries
- 💡 **User Experience**: Added confirmation dialogs for safe deletion operations
- 🛡️ **Data Integrity**: Duplicate event prevention mechanism
- 📱 **Responsive Design**: Mobile-friendly web interface
- 🎯 **Modular Architecture**: Separate servlets for different functionalities

---

## 🤝 Contributing

Contributions are welcome! If you'd like to improve this project:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add YourFeature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

---

## 📄 License

This project is open source and available for educational purposes.

---

## 📞 Contact

For questions or suggestions, please open an issue or contact the team leader.

---

## 🎓 Academic Context

This project was initially submitted in **Review 1** and further improved in **Review 2** to enhance:
- Validation techniques
- Code robustness
- Code quality
- User interaction

---

<div align="center">

**Made with ❤️ by the College Fest Management Team**

⭐ Star this repository if you find it helpful!

</div>
