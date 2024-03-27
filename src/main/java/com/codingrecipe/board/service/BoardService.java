package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
        private  final BoardRepository boardRepository;


        public void save(BoardDTO boardDTO) {
                boardRepository.save(boardDTO);
        }

        public List<BoardDTO> findAll() {
                return boardRepository.findAll();
        }

        public void updateHits(long id) {
                boardRepository.updateHits(id);
        }

        public BoardDTO findById(long id) {

                return boardRepository.findById(id);
        }

        public void update(BoardDTO boardDTO) {

                boardRepository.update(boardDTO);
        }

        public void delete(long id) {

                boardRepository.delete(id);
        }
}
