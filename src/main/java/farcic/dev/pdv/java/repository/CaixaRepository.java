package farcic.dev.pdv.java.repository;

import farcic.dev.pdv.java.entity.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {


}
