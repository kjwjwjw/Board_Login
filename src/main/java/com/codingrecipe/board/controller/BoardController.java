package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.dto.MemberDTO;
import com.codingrecipe.board.service.BoardService;
import com.codingrecipe.board.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;

            @GetMapping("/save")
            public String save() {
                return"save";
            }

            @GetMapping("/join")
            public String join() {

                return "join";
            }

            @PostMapping("/save")
            public String save(BoardDTO boardDTO) {
                System.out.println("boardDTO = "+ boardDTO);
                boardService.save(boardDTO);
                return "redirect:/list";
            }

            @PostMapping("/join")
            public String join(MemberDTO memberDTO) {
                System.out.println("memberDTO =" + memberDTO);
                memberService.join(memberDTO);
                return "redirect:/list";
            }

            @GetMapping("/list")
            public String findAll(Model model) {
                    List<BoardDTO> boardDTOList = boardService.findAll();
                    model.addAttribute("boardList", boardDTOList);
                System.out.println("boardDtoList = " + boardDTOList);
                    return "list";
            }

            @GetMapping("/{id}")
            public String findById(@PathVariable("id") Long id, Model model) {
                // 조회수 처리
                    boardService.updateHits(id);

                // 상세내용 가져옴
                BoardDTO boardDTO = boardService.findById(id);
                model.addAttribute("board", boardDTO);
                System.out.println("boardDto = " + boardDTO);

                return"detail";

            }


            @GetMapping("/update/{id}")
            public String update(@PathVariable("id") Long id, Model model) {
                BoardDTO boardDTO = boardService.findById(id);
                model.addAttribute("board", boardDTO);
                return "update";
            }

            @PostMapping("/update/{id}")
            public String update(BoardDTO boardDTO, Model model) {
                boardService.update(boardDTO);
                BoardDTO dto = boardService.findById(boardDTO.getId());
                model.addAttribute("board", dto);
                return "detail";
            }

            @GetMapping("/delete/{id}")
            public String delete(@PathVariable("id") Long id) {

                boardService.delete(id);

                return "redirect:/list";
            }

}
