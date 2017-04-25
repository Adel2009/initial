DROP TABLE IF EXISTS schedule;

CREATE TABLE schedule  (
    CRN INT PRIMARY KEY,
    Subj VARCHAR(60),
    CurseNumber INT,
    Term VARCHAR(200),
    Title VARCHAR(200),
    Days VARCHAR(60),
    Student_Capa INT,
    Instructor_Name VARCHAR(200)
);
