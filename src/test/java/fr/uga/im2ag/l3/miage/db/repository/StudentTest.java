package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Student;

import fr.uga.im2ag.l3.miage.db.repository.api.StudentRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

class StudentTest extends Base {

    StudentRepository studentRepository;

    @BeforeEach
    void before() {
        studentRepository = daoFactory.newStudentRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveStudent() {
        // final var student = Fixtures.createStudent(graduationClass);

        // entityManager.getTransaction().begin();
        // studentRepository.save(student);
        // entityManager.getTransaction().commit();
        // entityManager.detach(student);

        // var pStudent = studentRepository.findById(student.getId());
        // assertThat(pStudent).isNotNull().isNotSameAs(student);
        // assertThat(pStudent.getName()).isEqualTo(student.getName());
    }

    @Test
    List<Student> shouldFindStudentHavingGradeAverageAbove(float minAverage) {
        return studentRepository.findStudentHavingGradeAverageAbove(minAverage);
    }

}
