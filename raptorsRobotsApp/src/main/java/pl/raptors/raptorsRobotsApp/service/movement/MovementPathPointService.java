package pl.raptors.raptorsRobotsApp.service.movement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import pl.raptors.raptorsRobotsApp.domain.movement.MovementPath;
import pl.raptors.raptorsRobotsApp.domain.movement.MovementPathPoint;
import pl.raptors.raptorsRobotsApp.repository.movement.MovementPathPointRepository;
import pl.raptors.raptorsRobotsApp.service.CRUDService;

import java.util.List;

//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@Service
public class MovementPathPointService implements CRUDService<MovementPathPoint> {

    @Autowired
    MovementPathPointRepository repository;

    @Override
    public MovementPathPoint addOne(MovementPathPoint movementPathPoint) {
        return repository.save(movementPathPoint);
    }

    @Override
    public MovementPathPoint getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MovementPathPoint> getAll() {
        return repository.findAll();
    }

    @Override
    public MovementPathPoint updateOne(MovementPathPoint movementPathPoint) {
        return repository.save(movementPathPoint);
    }

    @Override
    public void deleteOne(MovementPathPoint movementPathPoint) {
        repository.delete(movementPathPoint);
    }

    List<MovementPathPoint> getPtsByMovementPath(MovementPath path) {
        return repository.findAllByPath(path);
    }
}
