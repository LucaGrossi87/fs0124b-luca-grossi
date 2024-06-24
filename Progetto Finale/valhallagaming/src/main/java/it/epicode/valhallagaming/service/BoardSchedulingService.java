package it.epicode.valhallagaming.service;

import it.epicode.valhallagaming.entity.Board;
import it.epicode.valhallagaming.entity.Lan;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardSchedulingService {

    @Autowired
    private BoardService boardService;

    @Autowired
    private LanService lanService;

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void resetAvailability(){
        List<Board> boardList = boardService.findAll();
        List<Lan> lanList = lanService.findAll();
        for (Board board : boardList){
            board.setAvailable(true);
            board.setOpen(false);
            board.setSeatsAvailable(board.getSeatsAvailable());
            boardService.save(board);
        }
        for (Lan lan : lanList){
            lan.setAvailable(true);
            lanService.save(lan);
        }
    }
}