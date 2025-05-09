package ra.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.api.model.entity.Role;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
