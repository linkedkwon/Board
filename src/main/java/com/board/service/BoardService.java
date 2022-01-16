package com.board.service;

import com.board.domain.Board;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(Board board){
        boardRepository.save(board);
    }

    public List<Board> findAllList(){
        return boardRepository.findAll();
    }

    public Board findOne(long id){
        return boardRepository.findBoardById(id);
    }
}
