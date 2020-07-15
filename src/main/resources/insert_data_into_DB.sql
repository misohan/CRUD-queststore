INSERT INTO users (Id, firstname, lastname, email, password, isadmin)
VALUES (DEFAULT , 'Darek', 'Czarek', 'darekczarek@codecool.pl', 'abcd', 'y');

INSERT INTO users (Id, firstname, lastname, email, password, isadmin)
VALUES (DEFAULT , 'Kondzio', 'Bondzio', 'kondziobondzio@codecool.pl', '1234', 'n');


INSERT INTO artifacts (Id, title, description, credit)
VALUES (DEFAULT , 'Private mentoring', 'Choose any Mentor on private mentoring for 1 hour', '50');

INSERT INTO artifacts (Id, title, description, credit)
VALUES (DEFAULT , 'Home office', 'You can spend a day in home office', '300');

INSERT INTO artifacts (Id, title, description, credit)
VALUES (DEFAULT , 'Extend deadline', 'extend SI week assignment deadline by one day', '500');


INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'Mistake', 'Spot a major mistake in the assignment', '50');

INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'Demo', 'Doing a demo for the class (side project, new technology, ...)', '100');

INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'Screening process', 'Taking part in the student screening process', '100');

INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'Workshop', 'Organizing a workshop for other students', '400');

INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'Dont be late' , 'Attend 1 months without being late', '300');

INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'SMART goal' , 'Set up a SMART goal accepted by a mentor, then achieve it', '1000');

INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'The best project' , 'Students choose the best project of the week. Selected team scores', '500');

INSERT INTO quests (Id, title, description, credit)
VALUES (DEFAULT , 'Meet-up' , 'Do a presentation on a meet-up', '500');