//package it.epicode.valhallagaming.service;
//
//import it.epicode.valhallagaming.entity.Board;
//import it.epicode.valhallagaming.repository.BoardRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BoardService {
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    public List<Board> findAll(){
//        return boardRepository.findAll();
//    }
//
//    public Optional<Board> findById (Long id){
//        return boardRepository.findById(id);
//    }
//
//    public Board save (Board board){
//        return boardRepository.save(board);
//    }
//
//    public void deleteById(Long id){
//        boardRepository.deleteById(id);
//    }
//
//    public List<Board> findAvailable(){
//        return boardRepository.findByAvailable(true);
//    }
//
//    public List<Board> findOpen(){
//        return boardRepository.findByOpen(true);
//    }
//}
