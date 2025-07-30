//package qucoon.mod.SpringServerless.base.service.Implementation;
//
//
//import qucoon.mod.SpringServerless.base.repository.BaseRepository;
//import qucoon.mod.SpringServerless.base.model.BaseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import qucoon.mod.SpringServerless.base.service.BaseService;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//public abstract class BaseServiceImpl<T extends BaseEntity, ID> implements BaseService<T, ID> {
//
//    protected final BaseRepository<T, ID> repository;
//
//    protected BaseServiceImpl(BaseRepository<T, ID> repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public List<T> getAll() {
//        return repository.findAll();
//    }
//
//    @Override
//    public Optional<T> getById(ID id) {
//        return repository.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public T create(T entity) {
//        // Set audit fields if needed
//        entity.setDateCreated(LocalDateTime.now());
//        return repository.save(entity);
//    }
//
//    @Override
//    @Transactional
//    public T update(ID id, T entity) {
//        Optional<T> optionalEntity = repository.findById(id);
//        if (optionalEntity.isPresent()) {
//            T existingEntity = optionalEntity.get();
//            // Copy properties from entity to existingEntity as needed.
//            entity.setId(existingEntity.getId());
//            entity.setDateModified(LocalDateTime.now());
//            return repository.save(entity);
//        } else {
//            throw new RuntimeException("Entity not found");
//        }
//    }
//
//    @Override
//    @Transactional
//    public void delete(ID id) {
//        Optional<T> optionalEntity = repository.findById(id);
//        if (optionalEntity.isPresent()) {
//            T entity = optionalEntity.get();
//            entity.setDeleted(true);
//            repository.save(entity);
//        } else {
//            throw new RuntimeException("Entity not found");
//        }
//    }
//
//    @Override
//    @Transactional
//    public T disable(ID id) {
//        Optional<T> optionalEntity = repository.findById(id);
//        if (optionalEntity.isPresent()) {
//            T entity = optionalEntity.get();
//            entity.setActive(false);
//            return repository.save(entity);
//        } else {
//            throw new RuntimeException("Entity not found");
//        }
//    }
//
//    @Override
//    @Transactional
//    public T enable(ID id) {
//        Optional<T> optionalEntity = repository.findById(id);
//        if (optionalEntity.isPresent()) {
//            T entity = optionalEntity.get();
//            entity.setActive(true);
//            return repository.save(entity);
//        } else {
//            throw new RuntimeException("Entity not found");
//        }
//    }
//
//    @Override
//    @Transactional
//    public void hardDelete(ID id) {
//        repository.deleteById(id);
//    }
//}
//
