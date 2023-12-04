| The script | Actions | Expected result | Actual result | Appraisal |
|:-----------|:--------|:----------------|:--------------|:----------|
| 001-1: Running the application without an internet connection | Run the application <br /> | Page is missing | Page is missing | Passed |
| 001-2: Running an application with an internet connection | Run the application <br /> | Page is present | Page is present | Passed |
| 002-1: Go to the home page | Once on the site, click on the "Home" button <br /> | Display slogan page | Display slogan page | Passed |
| 002-2: Go to the tasks page | Once on the site, click on the "Tasks" button <br /> | Display tasks page | Display tasks page | Passed |
| 002-3: Go to the api page | Once on the site, click on the "API" button | Display Swagger page | Display Swagger page | Passed |
| 002-4: Go to the "sign in/sign up" page | Once on the site, click on the "sign in"/"sign up" button | Display of relevant sections with authorization/registration | Display of relevant sections with authorization/registration | Passed |
| 003-1: Adding a new task | 1. Enter the task text in the field next to the "Add task" button <br /> 2. Click on "Add task" button | A new task will appear in the task list | A new task will appear in the task list | Passed |
| 003-2: Changing a task (without page refresh) | 1. Click on the "Edit" button next to the task <br /> 2. In the modal window, edit the task text <br /> 3. Click on the "Confirm" button | The task in the task list has changed | The task on the task list remains the same | Failed |
| 003-3: Changing a task (with page refresh) | 1. Click on the "Edit" button next to the task <br /> 2. In the modal window, edit the task text <br /> 3. Click on the "Confirm" <br /> 4. Refresh page | The task in the task list has changed | The task in the task list has changed | Passed |
| 003-4: Marking the completion of a task | Click on the task check box | The task has changed completion status | The task has changed completion status | Passed |
| 003-5: Deleting a task | Click on the delete button next to the task | The task has been removed from the task list | The task has been removed from the task list | Passed |
| 004-1: No user account to be entered | 1. Go to the sign in page <br />2. Enter nonexistent account login credentials | Displaying an error window | Displaying an error window | Passed |
| 004-2: Correct creation of a new user account | 1. Go to the sign up page<br />2. Enter the registration data to create an account | Successful user registration, automatic authorization and display of the page with tasks | Successful user registration, displaying the sign in page | Failed |