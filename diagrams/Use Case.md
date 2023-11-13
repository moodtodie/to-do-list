# Use case diagram

![Use case diagram](https://github.com/moodtodie/to-do-list/blob/main/diagrams/images/UseCase.png)

# Glossary

| Term                         | Definition                                                |
|:-----------------------------|:----------------------------------------------------------|
| User                         | A person who uses the application                         |
| Registered User              | A user who has previously registered with the application |
| Guest                        | A user using the application without authorization        |

# Flow of events

# Content
1 [Actors](#actors)  
2 [Use Cases](#use_case)  
2.1 [Login to your account](#sign_in_to_your_account)  
2.2 [Register](#sign_up)  
2.3 [View list of tasks](#view_task_list)  
2.4 [Add task](#add_task)  
2.5 [Delete task](#remove_task)  
2.6 [Log out of your account](#sign_out_of_your_account)  

<a name="actors"/>

# 1 Actors

| Actors          | Description                                               |
|:----------------|:----------------------------------------------------------|
| User            | A person who uses the application                         |
| Registered User | A user who has previously registered with the application |
| Guest           | A user using the application without authorization        |


<a name="use_case"/>

# 2 Use Cases

<a name="sign_in_to_your_account"/>

## 2.1 Login to your account

**Description.** The Login to Your Account use case allows the user to log into an account.  
**Preconditions.** The user chose the "Sign in" method to log into the application.   
**Main flow.**  
1. The application displays the account login window; 
2. The user enters the username and password; 
3. The application remembers the username; 
4. The application assigns the user the status "registered"; 
5. The application hides the account login window; 
6. The use case ends.

**Postconditions.** Use case running "[View list of tasks](#view_task_list)".  

<a name="sign_up"/>

## 2.2 Register

**Description.** The "Register" use case allows the user to create an account in the application.  
**Preconditions.** The user selected the "Sign up" method to enter the application, or the visitor expressed a desire to register in the application by selecting the "Sign up" menu item.  
**Main flow.**  
1. The application displays a registration window asking the user to enter a name;
2. The user enters username;
3. The user confirms the username entry;
4. The application checks the entered username for a match with the username of already registered users. If a match is found, alternate thread A1 is executed;
5. The application creates a user profile file;
6. The application assigns the user the status "registered";
7. The application hides the registration window;
8. The use case ends.

**Alternate flow A1.**
1. The application informs the user that a user with the same name already exists;
2. The application prompts the user to enter a different name;
3. Return to point 2 of the main flow.

**Additional information.** The user has the opportunity to cancel the action before confirming the name entry. In case of cancellation, alternative thread A2 is executed.

**Alternate flow A2.**
1. The application hides the registration window;
2. The use case ends early.

<a name="view_task_list"/>

## 2.3 View list of tasks

**Description.** The View Job List use case loads information from the user's profile.  
**Preconditions.** The user has logged into the application or a registered user has changed the list of tasks.  
**Main flow.**  
1. The application receives a list of tasks from the user profile;
2. The application displays tasks from the list in the table of the main application window.
3. The use case ends.

<a name="add_task"/>

## 2.4 Add task

**Description.** The Add Task use case allows a registered user to add a new task to their collection.  
**Preconditions.** A registered user clicked on the "Add" button.  
**Main flow.**
1. The user clicks on the "Add" button in the window with the list of tasks;
2. The application adds a new task to the list of user tasks;
3. The application displays an updated list of tasks;
4. The use case ends.

<a name="remove_task"/>

## 2.5 Delete task

**Description.** The Delete Task use case allows a registered user to remove a task from their collection.  
**Preconditions.** A registered user highlighted the task name in the list and clicked the "Delete" button.  
**Main flow.**
1. The user clicks on the "Remove" button;
2. The application receives the name of the selected task;
3. The application removes the task from the list;
4. The application displays an updated list of tasks;
5. The use case ends.

<a name="sign_out_of_your_account"/>

## 2.6 Log out of your account

**Description.** The Log Out use case allows a registered user to log out of their account..  
**Preconditions.** The registered user clicked on the "Logout" button.  
**Main flow.**  

1. The use case starts when the registered user selects the "Logout" menu item on the main application window;
2. The application hides the main application window;
3. The application displays the application login window;
4. The use case ends.
