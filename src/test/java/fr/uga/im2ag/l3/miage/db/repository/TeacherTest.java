package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;
import fr.uga.im2ag.l3.miage.db.repository.api.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TeacherTest extends Base {

    TeacherRepository teacherRepository;

    @BeforeEach
    void before() {
        teacherRepository = daoFactory.newTeacherRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveTeacher(Subject subject, GraduationClass classe, Student[] favs)  {

        final var teacher = Fixtures.createTeacher(subject, classe, favs);

        entityManager.getTransaction().begin();
        teacherRepository.save(teacher);
        entityManager.getTransaction().commit();
        entityManager.detach(teacher);

        var pTeacher = teacherRepository.findById(teacher.getId());
        assertThat(pTeacher).isNotNull().isNotSameAs(teacher);

    }

    @Test
    Teacher shouldFindHeadingGraduationClassByYearAndName(int year, String name) {
        final Teacher teacher = teacherRepository.findHeadingGraduationClassByYearAndName(year, name);
        return teacher;
    }

}
