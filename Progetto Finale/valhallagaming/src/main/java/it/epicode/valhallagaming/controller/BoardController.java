package it.epicode.valhallagaming.controller;

import it.epicode.valhallagaming.dto.boardDTO.BoardCreateRequest;
import it.epicode.valhallagaming.dto.boardDTO.BoardDeleteResponse;
import it.epicode.valhallagaming.dto.boardDTO.BoardEditRequest;
import it.epicode.valhallagaming.dto.boardDTO.BoardResponse;
import it.epicode.valhallagaming.dto.boardDTO.BoardResponse;
import it.epicode.valhallagaming.entity.Board;
import it.epicode.valhallagaming.entity.Board;
import it.epicode.valhallagaming.service.BoardService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<BoardResponse> getAllBoards() {
        return boardService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/available")
    public List<BoardResponse> getBoardsAvailable() {
        return boardService.findAvailable().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/open")
    public List<BoardResponse> getBoardsOpen() {
        return boardService.findOpen().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping ("/{id}")
    public BoardResponse getBoardById(@PathVariable Long id){
        Optional<Board> board = boardService.findById(id);
        return board.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public BoardResponse createBoard (@RequestBody BoardCreateRequest boardCreateRequest){
        Board board = convertToEntity(boardCreateRequest);
        Board savedBoard = boardService.save(board);
        return convertToDTO(savedBoard);
    }

    @PutMapping ("/{id}")
    public BoardResponse editBoard (@PathVariable Long id, @RequestBody BoardEditRequest boardEditRequest){
        Board board = convertToEntity(boardEditRequest);
        board.setId(id);
        Board updatedBoard = boardService.save(board);
        return convertToDTO(updatedBoard);
    }

    @DeleteMapping ("/{id}")
    public BoardDeleteResponse deleteBoard (@PathVariable Long id){
        boardService.deleteById(id);
        BoardDeleteResponse response = new BoardDeleteResponse();
        response.setId(id);
        response.setMessage("Board eliminato");
        return response;
    }

    private BoardResponse convertToDTO (Board board){
        BoardResponse dto = new BoardResponse();
        dto.setId(board.getId());
        dto.setAvailable(board.isAvailable());
        dto.setBookingList(board.getBookingList());
        dto.setSeatsTotal(board.getSeatsTotal());
        dto.setSeatsAvailable(board.getSeatsAvalaible());
        dto.setOpen(board.isOpen());
        return dto;
    }

    private Board convertToEntity (BoardCreateRequest dto){
        return new Board(dto.isAvailable(), dto.getBookingList(),dto.getSeatsTotal(),dto.getSeatsAvailable(), dto.isOpen());
    }

    private Board convertToEntity (BoardEditRequest dto){
        return new Board(dto.isAvailable(), dto.getBookingList(),dto.getSeatsTotal(), dto.getSeatsAvailable(), dto.isOpen());
    }

    @PutMapping("/boardbookingclose")
    public BoardResponse boardBookingClose (@RequestParam int guests) {
        List<Board> boardList = boardService.findAvailable();
        if (!boardList.isEmpty()) {
            Board bookedBoard = null;
            int closestDiff = Integer.MAX_VALUE;
            for (Board board : boardList){
                if (board.getSeatsTotal()>=guests){
                int diff = board.getSeatsTotal()-guests;
                if (diff < closestDiff){
                    closestDiff = diff;
                    bookedBoard=board;
                }
            } else {
                throw new EntityNotFoundException("Postazione non trovata");
                }
            }
            bookedBoard.setAvailable(false);
            Board updatedBoard = boardService.save(bookedBoard);
            bookedBoard.setSeatsAvalaible(bookedBoard.getSeatsAvalaible() - guests);
            return convertToDTO(updatedBoard);
        } else {
            throw new EntityNotFoundException("Postazione non trovata");
        }
    }

    @PutMapping("/{id}/boardbookingopen")
    public BoardResponse boardBookingOpen (@PathVariable Long id, @RequestParam int guests) {
        Optional<Board> optionalBoard = boardService.findById(id);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setSeatsAvalaible(board.getSeatsAvalaible() - guests);
            if (board.getSeatsAvalaible()<0){
                throw new RuntimeException("Posti non disponibili");
            } else if (board.getSeatsAvalaible()==0) {
                board.setAvailable(false);
            }
            board.setOpen(true);
            Board updatedBoard = boardService.save(board);
            return convertToDTO(updatedBoard);
        } else {
            throw new EntityNotFoundException("Postazione non trovata");
        }
    }
}
