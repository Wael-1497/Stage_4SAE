package tn.sae.partnership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sae.partnership.entity.Partnership;

@Repository
public interface PartnershipRepository extends JpaRepository<Partnership, Integer> {
}
