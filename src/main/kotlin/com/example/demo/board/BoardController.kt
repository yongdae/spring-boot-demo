package com.example.demo.board

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController {

    @Autowired
    private lateinit var boardRepository: BoardRepository

    @GetMapping("list")
    @ResponseBody
    fun list(): ResponseEntity<List<Board>> {
        return ResponseEntity.ok(boardRepository.findAll())
    }

    @PostMapping
    fun create(): ResponseEntity<String> {
        boardRepository.save(Board())
        return ResponseEntity.ok("success")
    }
}