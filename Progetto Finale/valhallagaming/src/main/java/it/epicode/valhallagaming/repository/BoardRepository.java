package it.epicode.valhallagaming.repository;

import it.epicode.valhallagaming.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByAvailable (boolean available);

    List<Board> findByOpen (boolean open);

}
