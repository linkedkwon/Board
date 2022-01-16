package com.board.controller;

import com.board.domain.Board;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String renderBoard(Model model){
        List<Board> items = boardService.findAllList();

        if(items.isEmpty())
            model.addAttribute("msg", "NODATA");
        else
            model.addAttribute("item", items);

        return "basic-table";
    }

    @GetMapping("/write")
    public String renderWrite(Model model){
        model.addAttribute("obj", new Board());
        return "write";
    }

    @GetMapping("/info")
    public String renderInfo(@RequestParam(value = "id") long id,
                             Model model){
        model.addAttribute("obj", boardService.findOne(id));
        return "info";
    }

    @PostMapping("/board/create")
    public String createBoard(Board board){
        boardService.createBoard(board);
        return "redirect:/board";
    }

}
