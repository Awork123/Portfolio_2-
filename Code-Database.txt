DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS grade;


Create table if not exists student (
                                       studentID INTEGER PRIMARY KEY NOT NULL ,
                                       studentName VARCHAR NOT NULL,
                                       City VARCHAR NOT NULL,
                                       grade FLOAT,

                                       FOREIGN KEY (grade) REFERENCES grade (gradeResult) ON DELETE RESTRICT ON UPDATE CASCADE

);

Create table if not exists course (
                                      courseID INTEGER PRIMARY KEY NOT NULL ,
                                      courseName VARCHAR NOT NULL,
                                      semester VARCHAR NOT NULL,
                                      teacherName VARCHAR NOT NULL


);
Create table if not exists grade (
                                     ID INTEGER PRIMARY KEY AUTOINCREMENT,
                                     studentID INTEGER NOT NULL ,
                                     courseID INTEGER NOT NULL,
                                     gradeResult FLOAT,

                                     FOREIGN KEY (courseID)REFERENCES course (courseID) ON DELETE RESTRICT ON UPDATE CASCADE,
                                     FOREIGN KEY (studentID) REFERENCES student (studentID) ON DELETE RESTRICT ON UPDATE CASCADE


);


INSERT INTO student (studentID, studentName, City) values  (1, 'Aisha Lincoln', 'Nykøbing F'),
                                                           (2, 'Anya Nielsen', 'Nykøbing F'),
                                                           (3, 'Benjamin Jensen' , 'Camas'),
                                                           (4, 'Berta Bertelsen', 'Billund'),
                                                           (5, 'Albert Antonsen', 'Sorø'),
                                                           (6, 'Eske Eriksen', 'Eskildstrup'),
                                                           (7, 'Olaf Olesen', 'Odense'),
                                                           (8, 'Salma Simonsen', 'Stockholm'),
                                                           (9, 'Theis Thomasen', 'Tølløse'),
                                                           (10, 'Janet jensen', 'Jyllinge');


INSERT INTO course (courseID, courseName, semester, teacherName) VALUES (1, 'SD 2019', 'autumn', 'Line'),
                                                                        (2, 'SD 2020', 'spring', 'Line'),
                                                                        (3, 'ES1 2019', 'autumn', 'Ebbe');


INSERT INTO grade (studentID, courseID, gradeResult) VALUES (1, 1, 12 ), (1, 2, null), (1, 3, 10),
                                                            (2, 1, null ), (2, 2, null), (2, 3, 12),
                                                            (3, 1, 7 ), (3, 2, null), (3, 3, 10),
                                                            (4, 1, null ), (4, 2, null), (4, 3, 2),
                                                            (5, 1, 10 ), (5, 2, null), (5, 3, 7),
                                                            (6, 1, null ), (6, 2, null), (6, 3, 10),
                                                            (7, 1, 4 ), (7, 2, null), (7, 3, 12),
                                                            (8, 1, null ), (8, 2, null), (8, 3, 12),
                                                            (9, 1, 12 ), (9, 2, null), (9, 3, 12),
                                                            (10, 1, null ), (10, 2, null), (10, 3, 7);



SELECT grade.studentID FROM grade JOIN student ON grade.studentID = student.studentID;


SELECT AVG(gradeResult) FROM grade WHERE courseID=3;
SELECT AVG(gradeResult) FROM grade WHERE studentID=3;





