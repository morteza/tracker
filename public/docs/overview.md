# Ratnic Tracker.
## Developer Manual

In the following sections, the architecture behind Ratnic Tracker is described. In the first part, the whole data model is described, although event-driven software was in mind, and these models have been extracted after defining events, requests, actions, and responses.

### Anatomy

The project is developed using MVC software design pattern in mind. It started with some basic and common models to initiate the data model (and CRUD actions for them), then the controllers' actions and corresponding views, and finally develop new required models, improve them, add fields and methods, set new constraints, and even possibly remove data models.

Some 3rd-party modules and functionalities are used like `play.mvc.Security.Authenticated` and similar ones for basic security, caching, database transactions, etc.

### Models

In addition to all actions which are necessary to service the user, the following CRUD-like actions have to be implemented and its view have to be designed:
- ***`index()`*** action method, with some pagination and ordering parameters.
- **LIST**, as *`show()`* with optional search, ordering, and pagination parameters.
- **Create**, as *`create()`* which renders the view to fill usually a form to create a new record of the model. Other than visualization or model-related parameters, it accepts no other parameter. The form has be submitted to the `submit()` action via `POST` method.
- **Update**, as *`edit()`* action method by which an id is passed and proper view to show a form with filled values of a record, is rendered. The form has be submitted to the `submit()` action via `POST` method.
- **Save**, as *`submit()`* action which validates and save the passed record into the database. The parameter can be either new record to be saved, or existing record to be updated. It is upon implementation how to detect these two kind of requests to this action.