package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.From;

import org.hibernate.sql.Select;

import java.util.Collection;
import java.util.List;

public class SubjectRepositoryImpl extends BaseRepositoryImpl implements SubjectRepository {


    public SubjectRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Subject entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Subject entity) {
        entityManager.remove(entity);
    }

    @Override
    public Subject findById(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        if(subject == null){
            throw new EntityNotFoundException("Can't find id");
        }
        return subject;
    }

    @Override
    public List<Subject> getAll() { 
        return entityManager.createQuery("SELECT * FROM Subject", Subject.class).getResultList();
    }

    @Override
    public Collection<Teacher> findTeachers(Long id) {
        // TODO
        return null;
    }
}
