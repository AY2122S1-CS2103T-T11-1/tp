---
layout: page
title: Joel Sung's Project Portfolio Page
---

### Project: NUS Tracker

NUS Tracker - (to include description of project here)

Given below are my contributions to the project.

* **New Feature**: Added the ability to create Events for students to enroll in.
  * Highlights: This feature was challenging to implement as a brand-new entity/class was introduced to the application. That required the AddressBook to now contain an event list, the GUI had to display the event list, the storage had to now store events and utility test classes had to be created to test event related classes and functions.

* **New Feature**: Added the ability to delete Events
  * Highlights: The DeleteCommand was made into an abstract class which DeleteStudentCommand and DeleteEventCommand inherit from. The DeleteCommandParser had to now account for the difference.
  
* **New Feature**: Added the ability to blacklist and whitelist Student IDs from events.
  * Highlights: Events had to have a new blacklist field. This meant that most of the test cases had to be changed to account for this extra variable. JSON files had to be edited to account for the blacklist field. The GUI had to display the blacklist, which had to be distinct from the event participants.

* * **New Feature**: Added the ability to list Events and Students
* Highlights: Created new commands and edited Help Window.

* **Code contributed**:

* **Project management**:

* **Enhancements to existing features**: Changed delete student by index to by student ID
  * Highlights: Whole implementation of delete student command had to be changed. New variables for testing were created to accommodate the new changes.


* **Documentation**:
  * User Guide:
    * Added documentation for the features `create`, `delete`, `events`, `students`, `blacklist` and `whitelist`.
  * Developer Guide:
    * Added implementation for events (updated Model and Storage class diagrams to include event aspects).
    * Updated Delete sequence diagram.
    * Added use cases for the features `create`, `delete`, `blacklist` and `whitelist`.
    
  

* **Community**:

* **Tools**:
