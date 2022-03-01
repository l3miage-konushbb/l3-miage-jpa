package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.repository.api.GraduationClassRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GraduationClassTest extends Base {

    GraduationClassRepository classRepository;

    @BeforeEach
    void before() {
        classRepository = daoFactory.newGraduationClassRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveClass() {
        // final var classe = Fixtures.createClass();

        // entityManager.getTransaction().begin();
        // classRepository.save(classe);
        // entityManager.getTransaction().commit();
        // entityManager.detach(classe);

        // var pClass = classRepository.findById(classe.getId());
        // assertThat(pClass).isNotNull().isNotSameAs(classe);
        // assertThat(pClass.getName()).isEqualTo(classe.getName());
    }


    @Test
    GraduationClass shouldFindByYearAndName(Integer year, String name) {
        return classRepository.findByYearAndName(year, name);
    }

}
