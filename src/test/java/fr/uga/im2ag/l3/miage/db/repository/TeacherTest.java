package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.repository.api.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void shouldSaveTeacher(Subject subject, GraduationClass classe, List<Student> favs)  {

        final var teacher = Fixtures.createTeacher(subject, classe, favs);

        entityManager.getTransaction().begin();
        subjectRepository.save(teacher);
        entityManager.getTransaction().commit();
        entityManager.detach(teacher);

        var pTeacher = teacherRepository.findById(teacher.getId());
        assertThat(pTeacher).isNotNull().isNotSameAs(teacher);
        assertThat(pTeacher.getName()).isEqualTo(teacher.getName());


    }

    @Test
    Teacher shouldFindHeadingGraduationClassByYearAndName(int year, string name) {
        var teacher = teacherRepository.findHeadingGraduationClassByYearAndName(year, name);
        return teacher;
    }

}
