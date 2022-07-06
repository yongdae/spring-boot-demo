package com.example.demo.board

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
internal class BoardRepositoryTest {

    @Autowired
    private lateinit var boardRepository: BoardRepository

    @Test
    fun create() {
        val board = Board()
        board.title = "제목 테스트";
        board.content = "본문 내용 Test";

        boardRepository.saveAndFlush(board)

        val newBoard = boardRepository.findAll().get(0)

        assertThat(newBoard.title).isEqualTo(board.title)
        assertThat(newBoard.content).isEqualTo(board.content)
    }

    @Test
    fun create_validation() {
        val board = Board()
        board.title = "제목 테스트";

        assertThatThrownBy { boardRepository.saveAndFlush(board) }
    }

    @Test
    fun list() {
        boardRepository.findAll()
    }
}


