# Requirements Document

## 1 Introduction

To-Do List is web applications that allow users to create and keep track of task lists. They can be useful for organizing personal time, managing projects, or simply keeping life in order.

## 2 User Requirements

### 2.1 System interfaces

- User environment: Browser with support for HTML5;
- Technical stack: HTML/CSS, Java(Spring Framework), PostgreSQL;
- Additional technologies: git.

### 2.2 User interface

You must register before using it for the first time

<img src="https://github.com/moodtodie/to-do-list/blob/main/mockups/sing_up.jpg" alt="Window for user registration">

In case you already have an account, you just need to log in.

<img src="https://github.com/moodtodie/to-do-list/blob/main/mockups/log_in.jpg" alt="Login window">

After registration/authorization you can finally start using To-Do List

<img src="https://github.com/moodtodie/to-do-list/blob/main/mockups/list.jpg" alt="Main application window">

### 2.3 Users Characteristics

To-Do Lists are geared towards people who want to be more organized and productive. They can be useful for people who: have many tasks to keep track of, work on several projects at the same time, have trouble meeting deadlines, want to improve their time management skills.

To-Do List is useful for people of any age, gender, education and social status. They can be used for both personal and work purposes. To-Do List will be a useful tool for increasing productivity and organizing your life.

### 2.4 Assumptions and Dependencies

This application will run on the server. You must have a connection to the server to run this application. All user data will also be stored on the server.

## 3 System requirements

### 3.1 Functional requirements

- Store user's to-do list
- Provide a means of editing the to-do list
- Mark to-do items as completed
- Add/delete to-do items

### 3.2 Quality requirements(Non-functional)

To-Do List should be easy to use and easy to understand for users of all backgrounds.

Also not insignificant qualities are:
 - Performance: The application should work quickly and without lags.
 - Reliability: The application should work stably and should not crash.
 - Security: The application must protect the privacy of users.
